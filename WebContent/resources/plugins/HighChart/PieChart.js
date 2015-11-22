$(function () {
      Highcharts.setOptions({
 colors: ['#00C853', '#F57C00', '#EEFF41', '#24CBE5', '#64E572', '#FF9655', '#CB2326','#6AF9C4']
});
    $('#container2').highcharts({
        
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false,
            type: 'pie'
        },
        title: {
            text: 'Xếp loại học lực'
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: true,
                    format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                    style: {
                        color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                    }
                }
            }
        },
        series: [{
            name: 'Brands',
            colorByPoint: true,
            data: [{
                name: 'Giỏi',
                y: 41.67
            }, {
                name: 'Khá',
                y: 33.33,
                selected: true
            }, {
                name: 'Trung bình',
                y: 16.67
            }, {
                name: 'Yếu',
                y: 8.33
            }]
        }]
    });
});