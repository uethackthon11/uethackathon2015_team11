$(function () {
    $('#container').highcharts({
        chart: {
            type: 'spline'
        },
        title: {
            text: 'Thống kê điểm'
        },
        xAxis: {
            categories: ['Kỳ 1 - 2012', 'Kỳ 2 - 2012', 'Kỳ 1 - 2013', 'Kỳ 2 - 2013', 'Kỳ 1 - 2014', 'Kỳ 2 - 2014',
                         'Kỳ 1 - 2015', 'Kỳ 2 - 2015']
        },
        yAxis: {
            title: {
                text: 'Điểm'
            },
            min: 0, max: 10
        },
        tooltip: {
            crosshairs: true,
            
        },
        plotOptions: {
            spline: {
                marker: {
                    radius: 4,
                    lineColor: '#666666',
                    lineWidth: 1
                }
            }
        },
        series: [{
        	name: 'Toán',
            data: [8, 9, 8.5, 10, 6, 9, 9, 9]

        }, {
        	name: 'Vật lý',
            data: [6, 8, 6, 4, 5, 3, 9, 6]
        }]
    });
});