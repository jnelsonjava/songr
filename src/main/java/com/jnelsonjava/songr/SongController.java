package com.jnelsonjava.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;

@Controller
public class SongController {
    @Autowired
    public SongRepository songRepository;

    @Autowired
    public AlbumRepository albumRepository;

    @PostMapping("/song")
    public RedirectView postSong(String title, int length, int trackNumber, long albumId) {
        Album album = albumRepository.getOne(albumId);
        Song song = new Song(title, length, trackNumber, album);
        songRepository.save(song);
        RedirectView redirect = new RedirectView(String.format("/album?albumId=%d", albumId));

        return redirect;
    }

    @GetMapping("/songs")
    public String showSongs(Model mSongs) {
        ArrayList<Song> songs = new ArrayList<>();
        // reference for sorting query https://www.baeldung.com/spring-data-sorting
        songs = (ArrayList<Song>) songRepository.findAll(Sort.by(Sort.Direction.ASC, "title"));
        mSongs.addAttribute("songs", songs);
        return "songs";
    }
}
