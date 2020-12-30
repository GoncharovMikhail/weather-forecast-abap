export default class WelcomePageGetRequestsExecutor {

    executeGetRequestForForecast(latitude, longitude) {
        window.location.href = '/getweather' + '?latitude=' + latitude + '&longitude=' + longitude;
    }
}