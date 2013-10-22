/*
$(function () {
  $('#input')
          .keyup(function (e) {
              if (e.keyCode === 13) {
                e.preventDefault();

                var $input = $('#input'),
                    command = $input.val();

                console.log("exec:", command);

                $input.val('');

                $.ajax({
                    url: '/q/',
                    data: {
                        command: command
                      }
                  });
              }
            });
  $('form#command').submit(function (e) { e.preventDefault(); });
  });
*/