package com.onurgundogdu.dto;

public class MoviesPack {
	private MoviesCsv movie;
	private LinkCsv link;
	private RatingCsv rating;
	private TagCsv tag;

	public MoviesPack(Builder builder) {
		this.movie = builder.movie;
		this.link = builder.link;
		this.rating = builder.rating;
		this.tag = builder.tag;
	}

	public MoviesCsv getMovie() {
		return movie;
	}

	public void setMovie(MoviesCsv movie) {
		this.movie = movie;
	}

	public LinkCsv getLink() {
		return link;
	}

	public void setLink(LinkCsv link) {
		this.link = link;
	}

	public RatingCsv getRating() {
		return rating;
	}

	public void setRating(RatingCsv rating) {
		this.rating = rating;
	}

	public TagCsv getTag() {
		return tag;
	}

	public void setTag(TagCsv tag) {
		this.tag = tag;
	}

	static class Builder {

		private MoviesCsv movie;
		private LinkCsv link;
		private RatingCsv rating;
		private TagCsv tag;

		public Builder addMovie(MoviesCsv movie) {
			this.movie = movie;
			return this;
		}

		public Builder addLinks(LinkCsv link) {
			this.link = link;
			return this;
		}

		public Builder addRating(RatingCsv rating) {
			this.rating = rating;
			return this;
		}

		public Builder addTag(TagCsv tag) {
			this.tag = tag;
			return this;
		}

		public MoviesPack build() {
			return new MoviesPack(this);
		}
	}

}
