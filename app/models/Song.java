package models;

import javax.persistence.*;

@Entity
public class Song {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	  public Long id;
    public String album;
    public String title;
    public String artist;
    public Integer duration;
}
