package com.jnelsonjava.songr;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class AlbumController {

    @GetMapping("/albums")
    public String showAlbums(Model mAlbums) {
        ArrayList<Album> albums = new ArrayList<>();
        albums.add(new Album("Wave Riders",
                "The Windsurfers",
                10,
                2100,
                // using https://homepages.cae.wisc.edu/~ece533/images/ for stock images
                "https://homepages.cae.wisc.edu/~ece533/images/sails.png"
        ));
        albums.add(new Album("Cat",
                "Cat",
                2,
                2320,
                "https://homepages.cae.wisc.edu/~ece533/images/cat.png"
        ));
        albums.add(new Album("Psych Lizard",
                "Tokyo Trainwreck",
                6,
                1736,
                "https://homepages.cae.wisc.edu/~ece533/images/frymire.png"
        ));

        mAlbums.addAttribute("albums", albums);

        return "albums";
    }
}
