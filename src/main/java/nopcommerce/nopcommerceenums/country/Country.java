package nopcommerce.nopcommerceenums.country;

public enum Country {
        UNITED_STATES("United States"),
        CANADA("Canada"),
        WALLIS_AND_FUTUNA("Wallis and Futuna"),
        VIETNAM("Vietnam"),
        IRAN("Iran");

        private final String country;

        private Country(String country) {
            this.country = country;
        }

        public String getCountry() {
            return country;
        }
}
