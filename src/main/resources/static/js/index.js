document.addEventListener("DOMContentLoaded", function() {
    const slides = document.querySelectorAll(".slideshow img");
    let currentSlide = 0;

    function nextSlide() {
        slides[currentSlide].classList.remove("visible");
        currentSlide = (currentSlide + 1) % slides.length;
        slides[currentSlide].classList.add("visible");
    }

    setInterval(nextSlide, 4000); // Change image every 4 seconds
});
