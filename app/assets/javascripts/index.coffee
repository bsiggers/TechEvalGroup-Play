$ ->
  $.get "/playlists", (playlists) ->
      $.each playlists, (index, playlist) ->
        $("#playlists").append $("<li>").text playlist.name ->
  $.get "/songs", (songs) ->
      $.each songs, (index, song) ->
        $("#songs").append $("<li>").text song.title
