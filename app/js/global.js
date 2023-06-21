$(document).ready(function() {
    toastr.options.timeOut = 5000;
  // Intercepta o evento de envio do formulário
$('#emailForm').submit(function(event) {
event.preventDefault(); // Impede o envio tradicional do formulário
var formData = {
    emailTo: $('#destinatario').val(),
    subject: $('#titulo').val(),
    text: $('#mensagem').val()
}; // Serializa os dados do formulário
var loadingOverlay = $('.loading-overlay');

// Exibe o ícone de carregamento e bloqueia a interação do usuário
loadingOverlay.removeClass('d-none');

// Faz a chamada AJAX para enviar os dados
$.ajax({
    type: 'POST',
    url: 'http://localhost:8080/api/enviar-email', // URL do endpoint Quarkus
    contentType: 'application/json',
    data: JSON.stringify(formData),
    success: function(response) {
    toastr.success('E-mail enviado com sucesso!');
    // Limpa o formulário
    $('#emailForm')[0].reset();
    },
    error: function() {
    toastr.error('Ocorreu um erro ao enviar o e-mail.');
    $('#emailForm')[0].reset();
    },
    complete: function() {
    // Esconde o ícone de carregamento e permite a interação do usuário novamente
    loadingOverlay.addClass('d-none');
    }
});
});
});