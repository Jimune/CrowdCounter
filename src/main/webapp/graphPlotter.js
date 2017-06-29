/**
 * Created by yvo.romp on 29/06/2017.
 */
getData();
var chart;
chart.title.text = "Zwolle";

function getData() {
    chart = Highcharts.chart('container', {
        /* chartheader info */
        chart: {
            type: 'line'
        },
        title: {
            text: 'connected Devices over Time'
        },
        subtitle: {
            text: 'location'
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
            data: giveDataFromDB()

        }, {
            name: 'Medium Strength',
            data: [83.6, 78.8, 98.5, 93.4, 106.0, 84.5, 105.0, 104.3, 91.2, 83.5, 106.6, 92.3]

        }, {
            name: 'High Strength',
            data: [48.9, 38.8, 39.3, 41.4, 47.0, 48.3, 59.0, 59.6, 52.4, 65.2, 59.3, 51.2]

        }]
    });
}

function giveDataFromDB() {
    var xhttp = new XMLHttpRequest();
    xhttp.open("GET", "/fetching", false);
    xhttp.send();
}
