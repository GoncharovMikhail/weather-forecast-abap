export default class WelcomePageDataVerifier {

    static verifyLatitude(latitudeToVerify) {
        if (/^(?:-|-?(?:\d|[1-8]\d?|90?)(?:\.[0-9]{0,6})?)$/.test(latitudeToVerify)) {
            return latitudeToVerify;
        } else {
            throw new Error("Incorrect input of latitude");
        }
    }

    static verifyLongitude(longitudeToVerify) {
        if (/^(?:-|-?(?:\d|[1-9]\d?|1(?:[0-7]\d?)?|1(?:80?)?)(?:\.[0-9]{0,6})?)$/.test(longitudeToVerify)) {
            return longitudeToVerify;
        } else {
            throw new Error("Incorrect input of latitude");
        }
    }

    static verifyLatitudeAndLongitude(latitudeToVerify, longitudeToVerify) {
        this.verifyLatitude(latitudeToVerify);
        this.verifyLongitude(longitudeToVerify);
    }

}