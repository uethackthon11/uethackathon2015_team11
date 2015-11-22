$(function () {
      Highcharts.setOptions({
 colors: ['#333', '#CB2326', '#DDDF00', '#24CBE5', '#64E572', '#FF9655', '#CB2326',      '#6AF9C4']
});
    $('#container2').highcharts({
        
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false,
            type: 'pie'
        },
        title: {
            text: 'Xếp loại học sinh'
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
                y: 56.33
            }, {
                name: 'Khá',
                y: 24.03,
                sliced: true,
                selected: true
            }, {
                name: 'Trung bình',
                y: 10.38
            }, {
                name: 'Yếu',
                y: 4.77
            }, {
                name: 'Kém',
                y: 0.91
            }]
        }]
    });
});