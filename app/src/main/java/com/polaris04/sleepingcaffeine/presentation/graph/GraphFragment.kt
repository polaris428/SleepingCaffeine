package com.polaris04.sleepingcaffeine.presentation.graph


import android.graphics.Color
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.*
import com.polaris04.sleepingcaffeine.R
import com.polaris04.sleepingcaffeine.databinding.FragmentGraphBinding
import com.polaris04.sleepingcaffeine.presentation.BaseFragment
import com.polaris04.sleepingcaffeine.presentation.graph.macker_view.MyMarkerView
import org.koin.android.ext.android.inject


internal class GraphFragment : BaseFragment<GraphViewModel, FragmentGraphBinding>() {
    companion object {
        var TAG = "GraphFragment"
    }

    override val viewModel by inject<GraphViewModel>()

    override fun getViewBinding() = FragmentGraphBinding.inflate(layoutInflater)

    override fun observeData() = viewModel.graphState.observe(this) {
        when (it) {
            is GraphState.UnInitialized -> {
                initView()
            }
            is GraphState.ListSuccess -> {

            }
        }
    }

    private fun initView() {
        initLineChart()
        initPieChart()
    }

    private fun initLineChart() = with(binding) {
        val lineDataSet = LineDataSet(lineMockData(), "속성명1")
        lineDataSet.lineWidth = 2f
        lineDataSet.circleRadius = 6f
        lineDataSet.setCircleColor(Color.parseColor("#FFA1B4DC"))
        lineDataSet.circleHoleColor = Color.BLUE
        lineDataSet.color = Color.parseColor("#FFA1B4DC")
        lineDataSet.setDrawCircleHole(true)
        lineDataSet.setDrawCircles(true)
        lineDataSet.setDrawHorizontalHighlightIndicator(false)
        lineDataSet.setDrawHighlightIndicators(false)
        lineDataSet.setDrawValues(false)

        val lineData = LineData(lineDataSet)
        lineChart.data = lineData


        val xAxis = lineChart.xAxis
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.textColor = Color.BLACK
        xAxis.enableGridDashedLine(8f, 24f, 0f)

        val yLAxis = lineChart.axisLeft
        yLAxis.textColor = Color.BLACK

        val yRAxis = lineChart.axisRight
        yRAxis.setDrawLabels(false)
        yRAxis.setDrawAxisLine(false)
        yRAxis.setDrawGridLines(false)

        val description = Description()
        description.text = ""

        lineChart.isDoubleTapToZoomEnabled = false
        lineChart.setDrawGridBackground(false)
        lineChart.description = description
        lineChart.animateY(2000, Easing.EaseInCubic)
        lineChart.invalidate()
        val marker = MyMarkerView(binding.root.context, R.layout.custim_markerview)
        marker.chartView = lineChart
        lineChart.marker = marker
    }


    private fun initPieChart() = with(binding){

        val pieEntries: ArrayList<PieEntry> = ArrayList()
        val label = "type"

        //initializing data
        val typeAmountMap: MutableMap<String, Int> = HashMap()
        typeAmountMap["Toys"] = 200
        typeAmountMap["Snacks"] = 230
        typeAmountMap["Clothes"] = 100
        typeAmountMap["Stationary"] = 500
        typeAmountMap["Phone"] = 50

        //initializing colors for the entries
        val colors: ArrayList<Int> = ArrayList()
        colors.add(Color.parseColor("#304567"))
        colors.add(Color.parseColor("#309967"))
        colors.add(Color.parseColor("#476567"))
        colors.add(Color.parseColor("#890567"))
        colors.add(Color.parseColor("#a35567"))
        colors.add(Color.parseColor("#ff5f67"))
        colors.add(Color.parseColor("#3ca567"))

        //input data and fit data into pie chart entry
        for (type in typeAmountMap.keys) {
            pieEntries.add(PieEntry(typeAmountMap[type]!!.toFloat(), type))
        }

        //collecting the entries with label name
        val pieDataSet = PieDataSet(pieEntries, label)
        //setting text size of the value
        pieDataSet.valueTextSize = 12f
        //providing color list for coloring different entries
        pieDataSet.colors = colors
        //grouping the data set from entry to chart
        val pieData = PieData(pieDataSet)
        //showing the value of the entries, default true if not set
        pieData.setDrawValues(true)
        pieChart.setData(pieData)
        pieChart.invalidate()



    }

    private fun lineMockData(): ArrayList<Entry> {
        val testData = arrayListOf<Entry>()
        for (i in 0..10) {
            testData.add(Entry(i.toFloat(), i.toFloat()))
        }
        return testData
    }

    private fun pieMokData(): MutableList<PieEntry>? {
        val testData = arrayListOf<PieEntry>()
        for (i in 1..10) {
            testData.add(PieEntry(i.toFloat(), i.toFloat()))
        }
        return testData
    }
    private fun showPieChart()= with(binding) {

    }



}