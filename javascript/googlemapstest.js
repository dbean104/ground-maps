
function initialise() {
    var mapProp = {
        center:new google.maps.LatLng(51.508742, -0.120850),
        zoom: 7,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    };
    var map=new google.maps.Map(
        document.getElementById("googleMap"),mapProp);
    //map.data.loadGeoJson('http://127.0.0.1:8887/grounds.json');
}
google.maps.event.addDomListener(window, 'load', initialise);