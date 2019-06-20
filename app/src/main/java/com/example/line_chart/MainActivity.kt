package com.example.line_chart


import android.graphics.Color.rgb
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

        val yMax= Collections.max(y)
        val yMin= Collections.min(y)

        val yVals = ArrayList<Entry>()

        for(i in y.indices){
            yVals.add(Entry(x.get(i),y.get(i)))
        }


        val set1: LineDataSet
        set1 = LineDataSet(yVals, "DataSet 1")

        set1.color = rgb(37, 231, 217)
        set1.setCircleColor(rgb(37, 231, 217))
        set1.lineWidth = 1f
        set1.circleRadius = 5f
        set1.setDrawCircleHole(false)
        set1.valueTextSize = 10f
        set1.valueTextColor = rgb(37, 231, 217)


        val dataSets = ArrayList<ILineDataSet>()
        dataSets.add(set1)
        val data = LineData(dataSets)

        // set data
        val week = arrayOf("","1", "2", "3", "4","5")
        lineChart.xAxis.granularity = 1f
        lineChart.xAxis.axisLineWidth = 2f
        lineChart.xAxis.axisLineColor = rgb(211,211,211)
        lineChart.xAxis.spaceMax = 1f
        lineChart.xAxis.spaceMin = 1f
        lineChart.xAxis.valueFormatter = IndexAxisValueFormatter(week)
        lineChart.xAxis.textSize = 12f

        lineChart.axisLeft.axisMaximum = yMax + 20
        lineChart.axisLeft.axisMinimum = yMin - 20
        lineChart.axisLeft.axisLineWidth = 2f
        lineChart.axisLeft.axisLineColor = rgb(211,211,211)
        lineChart.axisLeft.textSize = 15f
        lineChart.axisLeft.setDrawZeroLine(true)


        lineChart.setData(data)
        lineChart.description.isEnabled = false
        lineChart.legend.isEnabled = false
        lineChart.xAxis.position = XAxis.XAxisPosition.BOTTOM
        lineChart.xAxis.setDrawGridLines(false)
        lineChart.axisRight.isEnabled = false
        lineChart.setTouchEnabled(false)
        lineChart.setExtraOffsets(10f,20f,20f,10f)

    }

}
