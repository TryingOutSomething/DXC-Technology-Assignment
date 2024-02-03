document.addEventListener("DOMContentLoaded", function() {
    let languageSelection =  document.querySelector("#languageSelection")
    let queryParams = new URLSearchParams(window.location.search);

    let selectedLanguage = languageSelection.value;
    let currentLanguage = queryParams.get("lang");

    if (currentLanguage !== null && currentLanguage !== selectedLanguage) {
        languageSelection.value = currentLanguage
    }

    languageSelection.addEventListener("change", function() {
        let selectedLanguage = languageSelection.value;

        queryParams.set("lang", selectedLanguage)
        window.location.search = queryParams
    })
})