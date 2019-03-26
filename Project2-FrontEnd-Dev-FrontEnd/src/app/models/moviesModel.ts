interface MoviesModel {
  dates: {
    minimum: string;
    maximum: string;
  };
  page: number;
  results: Object[];
  total_pages: number;
  total_results: number;
}
