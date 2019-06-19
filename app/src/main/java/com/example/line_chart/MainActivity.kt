package com.example.line_chart

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupLineChartData()
    }

    private fun setupLineChartData() {
        val y = Arrays.asList(55f, 60f, 53f, 50f, 45f)
        val x = Arrays.asList(1f, 2f, 3f, 4f, 5f)

        val yVals = ArrayList<Entry>()

        for(i in y.indices){
            yVals.add(Entry(x.get(i),y.get(i)))
        }

//        yVals.add(Entry(1f, 55f))
//        yVals.add(Entry(2f, 60f))
//        yVals.add(Entry(3f, 53f))
//        yVals.add(Entry(4f, 50f))
//        yVals.add(Entry(5f, 45f))

        val set1: LineDataSet
        set1 = LineDataSet(yVals, "DataSet 1")

        // set1.fillAlpha = 110
        // set1.setFillColor(Color.RED);

        // set the line to be drawn like this "- - - - - -"
        // set1.enableDashedLine(5f, 5f, 0f);
        // set1.enableDashedHighlightLine(10f, 5f, 0f);
        set1.color = Color.rgb(37, 231, 217)
        set1.setCircleColor(Color.rgb(37, 231, 217))
        set1.lineWidth = 1f
        set1.circleRadius = 5f
        set1.setDrawCircleHole(false)
        set1.valueTextSize = 10f
        //set1.setDrawFilled(false)
        set1.valueTextColor = Color.rgb(37, 231, 217)


        val dataSets = ArrayList<ILineDataSet>()
        dataSets.add(set1)
        val data = LineData(dataSets)

        // set data
        val week = arrayOf("","1", "2", "3", "4","5")
//        val formatter = IAxisValueFormatter{
//            value, axis ->   months[value.toInt()]
//        }

        lineChart.xAxis.granularity = 1f
        lineChart.xAxis.axisMinimum = 0f
        lineChart.xAxis.axisMaximum = 6f
        //lineChart.axisLeft.granularity = 10f
        lineChart.xAxis.valueFormatter = IndexAxisValueFormatter(week)
        lineChart.axisLeft.axisMaximum = 80f
        lineChart.axisLeft.axisMinimum = 30f


        lineChart.setData(data)
        lineChart.description.isEnabled = false
        lineChart.legend.isEnabled = false
        //lineChart.setPinchZoom(true)
        //lineChart.setDrawGridBackground()
        //lineChart.xAxis.labelCount = 5
        lineChart.xAxis.position = XAxis.XAxisPosition.BOTTOM
        lineChart.xAxis.setDrawGridLines(false)
        //lineChart.xAxis.isEnabled = false
        lineChart.axisRight.isEnabled = false
        //lineChart.setTouchEnabled(false)
        //lineChart.setClickable(false)
        lineChart.setExtraOffsets(10f,20f,20f,10f)

    }

//    object WeekFormatter : IAxisValueFormatter {
//
//        override fun getFormattedValue(value: Float, axis: AxisBase?): String =   when  (value) {
//            1f -> "Week1"
//            2f -> "Week2"
//            3f -> "Week3"
//            4f -> "Week4"
//            5f -> "Week5"
//            else -> ""
//        }
//
//    }
}
