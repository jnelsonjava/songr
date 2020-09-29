package com.jnelsonjava.songr;

import org.junit.jupiter.api.Test;

import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertNotNull;

public class AlbumTest {

    // adding methods for repeatable and consistent Album creation
    private static Album generateAlbumOne() {
        return new Album(
                "a title",
                "some artist",
                10,
                2100,
                // using https://homepages.cae.wisc.edu/~ece533/images/ for stock images
                "https://homepages.cae.wisc.edu/~ece533/images/arctichare.png"
        );
    }

    @Test public void testNewAlbum() {
        // Instantiating an Album object and checking each value is set
        Album album = new Album(
                "a title",
                "some artist",
                10,
                2100,
                // using https://homepages.cae.wisc.edu/~ece533/images/ for stock images
                "https://homepages.cae.wisc.edu/~ece533/images/arctichare.png"
        );
        assertNotNull("album should exist", album);
        assertEquals("title should be set", "a title", album.title);
        assertEquals("artist should be set", "some artist", album.artist);
        assertEquals("song count should be set", 10, album.songCount);
        assertEquals("length should be set", 2100, album.length);
        assertEquals("imageUrl should be set", "https://homepages.cae.wisc.edu/~ece533/images/arctichare.png", album.imageUrl);

        // Instantiating a second Album for a second set of values
        Album album2 = new Album(
                "different title",
                "different artist",
                5,
                1000,
                "https://homepages.cae.wisc.edu/~ece533/images/sails.png"
        );
        assertNotNull("album should exist", album2);
        assertEquals("title should be set", "different title", album2.title);
        assertEquals("artist should be set", "different artist", album2.artist);
        assertEquals("song count should be set", 5, album2.songCount);
        assertEquals("length should be set", 1000, album2.length);
        assertEquals("imageUrl should be set", "https://homepages.cae.wisc.edu/~ece533/images/sails.png", album2.imageUrl);
    }

    @Test public void testGetAndSetTitle() {
        // Verifying getter and setter method
        Album album = generateAlbumOne();
        assertEquals("should return title", "a title", album.getTitle());
        album.setTitle("new title");
        assertEquals("should return newly set title", "new title", album.getTitle());
    }

    @Test public void testGetAndSetArtist() {
        // Verifying getter and setter method
        Album album = generateAlbumOne();
        assertEquals("should return artist", "some artist", album.getArtist());
        album.setArtist("new artist");
        assertEquals("should return newly set artist", "new artist", album.getArtist());

    }

    @Test public void testGetAndSetSongCount() {
        // Verifying getter and setter method
        Album album = generateAlbumOne();
        assertEquals("should return song count", 10, album.getSongCount());
        album.setSongCount(20);
        assertEquals("should return updated song count", 20, album.getSongCount());
    }

    @Test public void testGetAndSetLength() {
        // Verifying getter and setter method
        Album album = generateAlbumOne();
        assertEquals("should return length", 2100, album.getLength());
        album.setLength(100);
        assertEquals("should return updated length", 100, album.getLength());
    }

    @Test public void testGetAndSetImageUrl() {
        // Verifying getter and setter method
        Album album = generateAlbumOne();
        assertEquals("should return image url", "https://homepages.cae.wisc.edu/~ece533/images/arctichare.png", album.getImageUrl());
        album.setImageUrl("/capitalize/something");
        assertEquals("should return new image url", "/capitalize/something", album.getImageUrl());
    }


}
