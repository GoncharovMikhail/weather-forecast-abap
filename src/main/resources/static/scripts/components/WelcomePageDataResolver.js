export default class WelcomePageDataResolver {

    resolveLatitude() {
        return $('#input-latitude').val();
    }

    resolveLongitude() {
        return $('#input-longitude').val();
    }
}