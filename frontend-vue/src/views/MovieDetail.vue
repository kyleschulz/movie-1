<template>
  <div>
    <span>{{movie.movieTitle}}</span>
    <ul>
      <li>{{movie.rating.rating}}</li>
      <li>{{movie.movieLength}}</li>
      <li>{{movie.genre.genre}}</li>
      <li>{{movie.releaseDate}}</li>
    </ul>
    <iframe
      width="560"
      height="315"
      :src="movie.trailerUrl"
      frameborder="0"
      allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
      allowfullscreen
    ></iframe>
  </div>
</template>

<script>
export default {
  data: () => ({
    movie: null,
  }),
  async mounted() {
    const { data } = await this.$http.get(
      "http://localhost:8080/api/movies/" + this.$route.params.id
    );
    console.log(data);
    this.movie = data;
  },
};
</script>