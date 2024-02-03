document.addEventListener("DOMContentLoaded", function() {
    let languageSelection =  document.querySelector("#languageSelection")
    let currentLocale =  document.querySelector("#locale")

    let selectedLanguage = languageSelection.value;
    let currentLanguage = currentLocale.value;

    if (currentLanguage !== null && currentLanguage !== selectedLanguage) {
        languageSelection.value = currentLanguage
    }

    languageSelection.addEventListener("change", function() {
        let queryParams = new URLSearchParams(window.location.search);
        let selectedLanguage = languageSelection.value;

        queryParams.set("lang", selectedLanguage)
        window.location.search = queryParams
    })
})