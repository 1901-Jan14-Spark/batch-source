interface MoviesModel {
  dates: {
    maximum: string;
    minimum: string;
  }
  page: number;
  results: Object[];
  total_pages: number;
  total_results: number;
}
