package models;

import javax.persistence.*;

@Entity
public class PlaylistSong {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	  public Long id;
    public Long song_id;
    public Long playlist_id;
}
