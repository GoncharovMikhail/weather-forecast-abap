export default class WelcomePageDataVerifier {

    static verifyLatitude(latitude) {
        if (/^(?:-|-?(?:\d|[1-8]\d?|90?)(?:\.[0-9]{0,6})?)$/.test(latitude)) {
            return latitude;
        } else {
            throw new Error("Incorrect input of latitude")
        }
    }

    static verifyLongitude(longitude) {
        if (/^(?:-|-?(?:\d|[1-9]\d?|1(?:[0-7]\d?)?|1(?:80?)?)(?:\.[0-9]{0,6})?)$/.test(longitude)) {
            return longitude;
        } else {
            throw new Error("Incorrect input of latitude")
        }
    }
}