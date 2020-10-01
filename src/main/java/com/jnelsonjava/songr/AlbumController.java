package com.jnelsonjava.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;

@Controller
public class AlbumController {
    @Autowired
    public AlbumRepository albumRepository;

    @Autowired
    public SongRepository songRepository;

    @PostMapping("/albums")
    public RedirectView postAlbums(String title, String artist, int songCount, int length, String imageUrl) {
        Album newAlbum = new Album(title, artist, songCount, length * 60, imageUrl);
        albumRepository.save(newAlbum);

//        Song newSong = new Song("panda song", 240, 1, newAlbum);
//        songRepository.save(newSong);

        return new RedirectView("/albums");
    }

    @GetMapping("/albums")
    public String showAlbums(Model mAlbums) {
        ArrayList<Album> albums = new ArrayList<>();
        albums = (ArrayList<Album>) albumRepository.findAll();

//        // Section commented out for testing
//        albums.add(new Album("Wave Riders",
//                "The Windsurfers",
//                10,
//                2100,
//                // using https://homepages.cae.wisc.edu/~ece533/images/ for stock images
//                "https://homepages.cae.wisc.edu/~ece533/images/sails.png"
//        ));
//        albums.add(new Album("Cat",
//                "Cat",
//                2,
//                2320,
//                "https://homepages.cae.wisc.edu/~ece533/images/cat.png"
//        ));
//        albums.add(new Album("Psych Lizard",
//                "Tokyo Trainwreck",
//                6,
//                1736,
//                "https://homepages.cae.wisc.edu/~ece533/images/frymire.png"
//        ));

        mAlbums.addAttribute("albums", albums);

        return "albums";
    }

    @GetMapping("/album")
    public String showAlbum(Model mAlbum, @RequestParam("albumId") long albumId) {
        Album album = albumRepository.getOne(albumId);
        mAlbum.addAttribute("album", album);
        return "album";
    }
}
