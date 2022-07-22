$(document).ready(function(){
    $('select').formSelect();
  });

  $('.dropdown-trigger').dropdown({
    constrain_width: false, // Does not change width of dropdown to that of the activator
    hover: false, // Activate on hover
    gutter: 0, // Spacing from edge
    belowOrigin: true, // Displays dropdown below the button
    alignment: 'center' // Displays dropdown with edge aligned to the left of button
  }
);

$(document).ready(function(){
  $('.sidenav').sidenav();
});