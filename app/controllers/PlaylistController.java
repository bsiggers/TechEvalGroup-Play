package controllers;

import models.Playlist;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.List;

import static play.libs.Json.toJson;

public class PlaylistController extends Controller {

    private final FormFactory formFactory;
    private final JPAApi jpaApi;

    @Inject
    public PlaylistController(FormFactory formFactory, JPAApi jpaApi) {
        this.formFactory = formFactory;
        this.jpaApi = jpaApi;
    }

    public Result index() {
        return ok(views.html.index.render());
    }

    @Transactional
    public Result addPlaylist() {
        Playlist playlist = formFactory.form(Playlist.class).bindFromRequest().get();
        jpaApi.em().persist(playlist);
        //return redirect(routes.PlaylistController.index());
        return ok(views.html.index.render());
    }

    @Transactional(readOnly = true)
    public Result getPlaylists() {
        List<Playlist> playlists = (List<Playlist>) jpaApi.em().createQuery("select p from Playlist p").getResultList();
        return ok(toJson(playlists));
    }

}
