$(function () {
      Highcharts.setOptions({
 colors: ['#B0BEC5', '#F57C00', '#EEFF41', '#24CBE5', '#64E572', '#FF9655', '#CB2326','#6AF9C4']
});
      $('#container3').highcharts({
          chart: {
              type: 'column'
          },
          title: {
              text: 'Thống kê học lực từng môn'
          },
          xAxis: {
              categories: ['Toán', 'Vật lý', 'Hóa học', 'Sinh học', 'Tin học', 'Văn', 'Sử', 'Địa', 'Ngoại ngữ', 'GDCD']
          },
          yAxis: {
              min: 0,
              title: {
                  text: 'Số học sinh'
              }
          },
          tooltip: {
              pointFormat: '<span style="color:{series.color}">{series.name}</span>: <b>{point.y}</b> ({point.percentage:.0f}%)<br/>',
              shared: true
          },
          plotOptions: {
              column: {
                  stacking: 'percent'
              }
          },
          series: [{
              name: 'Giỏi',
              data: [7, 8, 5, 2, 5, 7, 1, 9, 6, 9]
          }, {
              name: 'Khá',
              data: [3, 1, 1, 0, 4, 1, 9, 0, 4, 9]
          }, {
              name: 'TB',
              data: [1, 1, 5, 8, 2, 2, 1, 2, 1, 2]
          },  {
              name: 'Yếu',
              data: [1, 2, 1, 2, 1, 2, 1, 1, 1, 1]
          }]
      });
});