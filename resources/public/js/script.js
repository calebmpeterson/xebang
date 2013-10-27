$(function () {
  // Switch the 'search' icon to the 'exclamation' icon when the first character is a '!'
  var $input = $('#input'),
      $go    = $('#go');
  $input
    .keyup(function (e) {
             var input = $input.val();
             if (input.length > 0 && input.charAt(0) === '!') {
               $go.find('i').addClass('icon-exclamation-sign').removeClass('icon-search');
             }
             else {
               $go.find('i').addClass('icon-search').removeClass('icon-exclamation-sign');
             }
           });
});