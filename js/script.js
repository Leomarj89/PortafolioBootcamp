// script.js

$(document).ready(function() {
  // Validación del formulario de contacto
  $('#formulario-contacto').on('submit', function(e) {
    e.preventDefault();

    const nombre = $('#nombre').val().trim();
    const email = $('#email').val().trim();
    const mensaje = $('#mensaje').val().trim();

    if (!nombre || !email || !mensaje) {
      alert('Por favor completa todos los campos.');
      return;
    }

    // Aquí podrías conectar con una API o backend
    alert('Gracias por tu mensaje, ' + nombre + '. ¡Te contactaré pronto!');
    $(this)[0].reset();
  });

  // Efecto de scroll suave a secciones
  $('a.nav-link').on('click', function(e) {
    if (this.hash !== '') {
      e.preventDefault();
      const hash = this.hash;
      $('html, body').animate({
        scrollTop: $(hash).offset().top - 70
      }, 800);
    }
  });

  // Mostrar/ocultar botón "ir arriba"
  $(window).on('scroll', function() {
    if ($(this).scrollTop() > 300) {
      $('#btn-top').fadeIn();
    } else {
      $('#btn-top').fadeOut();
    }
  });

  // Acción del botón "ir arriba"
  $('#btn-top').on('click', function() {
    $('html, body').animate({ scrollTop: 0 }, 600);
  });
});