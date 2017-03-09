package controllers;

import models.Song;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.List;

import static play.libs.Json.toJson;

public class SongController extends Controller {

    private final FormFactory formFactory;
    private final JPAApi jpaApi;

    @Inject
    public SongController(FormFactory formFactory, JPAApi jpaApi) {
        this.formFactory = formFactory;
        this.jpaApi = jpaApi;
    }

    public Result index() {
        return ok(views.html.index.render());
    }

    @Transactional
    public Result addSong() {
        Song song = formFactory.form(Song.class).bindFromRequest().get();
        jpaApi.em().persist(song);
        //return redirect(routes.SongController.index());
        return ok(views.html.index.render());
    }

    @Transactional(readOnly = true)
    public Result getSongs() {
        List<Song> songs = (List<Song>) jpaApi.em().createQuery("select s from Song s").getResultList();
        return ok(toJson(songs));
    }

}
