$(document).ready(function() {
$('#side-nav a').click(function(){

var toLoad = $(this).attr('href')+' #content';
$('#content').hide('fast',loadContent);
function loadContent() {
$('#content').load(toLoad,'',showNewContent())
}
function showNewContent() {
$('#content').show('normal');
}

return false;

});
});