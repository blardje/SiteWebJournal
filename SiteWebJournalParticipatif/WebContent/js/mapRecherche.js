//-----GMaps
var shape = null;
var map1;
var myOptions1;
var latlng;
var geocoder;

function initialize() {
    geocoder = new google.maps.Geocoder();
    
    /* Need internet */
    gmaps1();
   
    google.maps.visualRefresh = true;

    google.maps.event.addDomListener(window, 'load', initialize);
    
}

// Gamps
function gmaps1() {
		var circle = null;
        latlng = new google.maps.LatLng(46, 0);
        myOptions1 = {
            zoom: 6,
            center: latlng,
            mapTypeId: google.maps.MapTypeId.HYBRID,
            panControl: true,
            zoomControl: true,
            streetViewControl: false,
            mapTypeControl: true
        };
        map1 = new google.maps.Map(document.getElementById("mapCanvas"), myOptions1);

        /*-----------------------Drawing tools------------------*/
        var drawingManager = new google.maps.drawing.DrawingManager({
            drawingMode: google.maps.drawing.OverlayType.MARKER,
            drawingControl: true,
            drawingControlOptions: {
                position: google.maps.ControlPosition.TOP_CENTER,
                drawingModes: [
                    google.maps.drawing.OverlayType.CIRCLE,
                    google.maps.drawing.OverlayType.RECTANGLE,
                    google.maps.drawing.OverlayType.POLYGON
                ]
            },
            markerOptions: {
            },
            circleOptions: {
                fillColor: '#333',
                fillOpacity: 0.6,
                strokeWeight: 2,
                clickable: false,
                editable: true,
                zIndex: 1
            },
            rectangleOptions: {
                fillColor: '#333',
                fillOpacity: 0.6,
                strokeWeight: 2,
                strokeColor: "#000",
                editable: true
            }
        });
        drawingManager.setMap(map1);

        /*------------------GmapsListener------------------------*/
        google.maps.event.addListener(drawingManager, 'overlaycomplete', function(event) {
            if (shape !== null) {
                shape.setMap(null);
            }
            shape = event.overlay;
            if (event.type === google.maps.drawing.OverlayType.CIRCLE) {
                circle = event.overlay;
                var radius = circle.getRadius() / 1000;
                var center = circle.getCenter();
                var latitude = center.lat();
                var longitude = center.lng();
                
                $("#latitude").text("Lat : " + latitude.toString());
                $("#longitude").text("Long : " + longitude.toString());
                $("#rayon").text("Rayon : " + radius.toString() + " Km");
                
                geocoder.geocode({
                    'latLng': center
                }, function (results, status) {
                    if (status == google.maps.GeocoderStatus.OK) {
                        $("#lieu").text("Lieu : " + results[0].formatted_address);
                    } else {
                        alert('Geocoder failed due to: ' + status);
                    }
                });
            }
            
            google.maps.event.addListener(circle, 'radius_changed', function() {
                radius = circle.getRadius() / 1000;
                $("#rayon").text("Rayon : " + radius.toString() + " Km");
            });
            
            google.maps.event.addListener(circle, 'center_changed', function() {
                center = circle.getCenter();
                latitude = center.lat();
                longitude = center.lng();
                $("#latitude").text("Lat : " + latitude.toString());
                $("#longitude").text("Long : " + longitude.toString());
                
                geocoder.geocode({
                    'latLng': center
                }, function (results, status) {
                    if (status == google.maps.GeocoderStatus.OK) {
                        $("#lieu").text("Lieu : " + results[0].formatted_address);
                    } else {
                        alert('Geocoder failed due to: ' + status);
                    }
                });
            });
        });
}



