var app = (function () {

    var _map;

    var _markers;

    var markers;

    var bounds;
	
     document.addEventListener('DOMContentLoaded', function () {
    if (document.querySelectorAll('#map').length > 0)
    {
        if (document.querySelector('html').lang)
            lang = document.querySelector('html').lang;
        else
            lang = 'en';

        var js_file = document.createElement('script');
        js_file.type = 'text/javascript';
        js_file.src = 'https://maps.googleapis.com/maps/api/js?&signed_in=true&language=' + lang;
        document.getElementsByTagName('head')[0].appendChild(js_file);
    }
});
var _genTableAll = function(info){
        $("#tablaPaises > tbody").empty();
        info.map(function(country){
            $("#tablaPaises > tbody").append(
                "<tr> <td>" +
                country.name +
                "</td>" +
                "<td>" +
                country.deaths +
                "</td>" +
                "<td>" +
                country.confirmed +
                "</td>" +
                "<td>" +
                country.recovered +
                "</td></tr>"
            );
        });
    };
/*
    var _plotMarkers = function (ms) {
        _genTable(ms)
        markers = [];
        bounds = new google.maps.LatLngBounds();

        ms.forEach(function (marker) {
            console.log(marker.location.latitude, marker.location.longitude);
            var position = new google.maps.LatLng(marker.location.latitude, marker.location.longitude);

            markers.push(
                new google.maps.Marker({
                    position: position,
                    map: _map,
                    animation: google.maps.Animation.DROP
                })
            );

            bounds.extend(position);
        });
        _markers = markers;
        _map.fitBounds(bounds);
    };

    var initMap = function () {
        _map = new google.maps.Map(document.getElementById('map'), {
            center: {lat: -34.397, lng: 150.644},
            zoom: 8
        });

    };

    var _clearMarkers = function(){
        if (_markers){
            _markers.forEach(function (marker) {
                marker.setMap(null);
            });
        }

    };

    var findCovidByName = function (name){
        _clearMarkers();
        apiClient.getAirportsByName(name,_plotMarkers);
    };
*/	
	var findAll = function (){
        
        apiClient.getAll(_genTableAll);
    };

    return {
            
            
            findAll:findAll,
    }


})();