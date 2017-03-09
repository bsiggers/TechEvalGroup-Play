package models;

import javax.persistence.*;

@Entity
public class Playlist {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	  public Long id;
    public String name;
    
}
