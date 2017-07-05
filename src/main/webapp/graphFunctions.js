var chart;

function getData(title, weakHourmap, mediumHourmap, highHourmap) {
    chart = Highcharts.chart('container', {
        /* chartheader info */
        chart: {
            type: 'line'
        },
        title: {
            text: 'connected Devices over Time'
        },
        subtitle: {
            text: title
        },

        /* axis declaration */
        xAxis: {
            title: {
                text: 'timeperiod'
            },
            crosshair: true
        },
        yAxis: {
            min: 0,
            title: {
                text: 'Devices (per device)'
            }
        },


        /* combines values and boxes them together in hover table */
        tooltip: {
            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
            '<td style="padding:0"><b>{point.y:.1f} devices</b></td></tr>',
            footerFormat: '</table>',
            shared: true,
            useHTML: true
        },
        /* plots bars and sets padding distance between bars*/
        plotOptions: {
            column: {
                pointPadding: 0,
                borderWidth: 0
            }
        },
        series: [{
            name: 'Weak strength',
            data: weakHourmap

        }, {
            name: 'Medium Strength',
            data: mediumHourmap

        }, {
            name: 'High Strength',
            data: highHourmap

        }]
    });


}

function setImageVisible(id, visible) {
    var location = document.getElementById('location');
    var date = document.getElementById('date');
    console.log(location);
    console.log(date);
    if (location.value.length > 0 && date.value.length > 0) {
        console.log("inside");
        var img = document.getElementById(id);
        img.style.visibility = (visible ? 'visible' : 'hidden');
    }
}

function fetchLocation() {
    var input = document.getElementById("location").value;
    var table = document.getElementById("datatable");

    if (input.length <= 0) {
        table.innerHTML = "";
        return;
    }

    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            table.innerHTML = xhttp.responseText;
        }
    };

    xhttp.open("POST", "/fetchgraphloc", true);
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send("name=" + input);
}

function fillSearch(fill) {
    document.getElementById("location").value = fill;
    document.getElementById("datatable").innerHTML = "";
}

