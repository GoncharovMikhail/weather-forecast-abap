import WelcomePageManager from "./components/WelcomePageManager.js";

const welcomePageManager = new WelcomePageManager();

export function onSubmitButtonClick() {
    welcomePageManager.onSubmitButtonClicked();
}