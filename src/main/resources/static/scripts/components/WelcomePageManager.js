import WelcomePageDataResolver from "./WelcomePageDataResolver.js";
import WelcomePageDataVerifier from "./WelcomePageDataVerifier.js";
import WelcomePageGetRequestsExecutor from "./WelcomePageGetRequestsExecutor.js";

export default class WelcomePageManager {

    welcomePageDataResolver;
    welcomePageGetRequestsExecutor;

    constructor() {
        this.welcomePageDataResolver = new WelcomePageDataResolver();
        this.welcomePageGetRequestsExecutor = new WelcomePageGetRequestsExecutor();
    }

    onSubmitButtonClicked() {
        let latitude = this.welcomePageDataResolver.resolveLatitude();
        let longitude = this.welcomePageDataResolver.resolveLongitude();

        
        try {
            WelcomePageDataVerifier.verifyLatitude(latitude);
            WelcomePageDataVerifier.verifyLongitude(longitude);
        } catch (e) {
            alert('Wrong input');
        }
        

        this.welcomePageGetRequestsExecutor.executeGetRequestForForecast(latitude, longitude);
    }
}