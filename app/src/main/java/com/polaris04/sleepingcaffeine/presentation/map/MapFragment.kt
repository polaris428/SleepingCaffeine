package com.polaris04.sleepingcaffeine.presentation.map

import android.Manifest
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.os.Build
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat.checkSelfPermission
import com.google.android.gms.location.*
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.polaris04.sleepingcaffeine.R
import com.polaris04.sleepingcaffeine.databinding.FragmentMapBinding

import com.polaris04.sleepingcaffeine.presentation.BaseFragment
import com.polaris04.sleepingcaffeine.presentation.utilluty.ToastMare
import noman.googleplaces.*
import org.koin.android.ext.android.inject
import java.io.IOException
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet


internal class MapFragment() : BaseFragment<MapViewModel, FragmentMapBinding>(),
    PlacesListener {
    companion object {
        var TAG = "MapFragment"
    }

    private lateinit var mFusedLocationProviderClient: FusedLocationProviderClient

    lateinit var mLastLocation: Location
    private lateinit var mMap: GoogleMap
    // 현재 위치를 검색하기 위함

    var previousMarker: ArrayList<Marker> = arrayListOf()

    lateinit var currentPosition: LatLng
    var code = 0
    lateinit var mLocationRequest: LocationRequest
    override fun getViewBinding() = FragmentMapBinding.inflate(layoutInflater)

    override val viewModel by inject<MapViewModel>()
    override fun observeData() = viewModel.mapState.observe(this) {
        when (it) {
            is MapState.UnInitialized -> {
                initView()

                mapLiveData()
            }
        }
    }

    fun mapLiveData() = viewModel.mapLiveData.observe(this) {
        mMap = it

        startLocationUpdates()


    }

    private fun initView() {
        val permissions = arrayOf(
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION
        )

        mLocationRequest = LocationRequest.create().apply {

            priority = LocationRequest.PRIORITY_HIGH_ACCURACY

        }

        requirePermissions(permissions)


    }

    private fun initGoogleMap() {
        val mapFragment = childFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment!!.getMapAsync(viewModel.mapReadyCallback)
        binding.button.setOnClickListener {
            mMap.clear()
        }


    }

    private fun requirePermissions(permissions: Array<String>) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            permissionGranted()
        } else {
            val isAllPermissionsGranted = permissions.all {
                checkSelfPermission(
                    requireContext(),
                    it
                ) == PackageManager.PERMISSION_GRANTED
            }
            if (isAllPermissionsGranted) {
                permissionGranted()
            } else {
                ActivityCompat.requestPermissions(requireActivity(), permissions, 0)
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (grantResults.all { it == PackageManager.PERMISSION_GRANTED }) {
            permissionGranted()
        } else {
            permissionDenied()
        }
    }

    // 권한이 있는 경우 실행
    private fun permissionGranted() {
        initGoogleMap() // 권한이 있는 경우 구글 지도를준비하는 코드 실행

    }

    // 권한이 없는 경우 실행
    private fun permissionDenied() {
        Toast.makeText(
            activity, "권한 승인이 필요합니다.", Toast.LENGTH_LONG
        )
            .show()
    }


    private fun startLocationUpdates() {

        //FusedLocationProviderClient의 인스턴스를 생성.
        mFusedLocationProviderClient =
            LocationServices.getFusedLocationProviderClient(requireActivity())
        if (ActivityCompat.checkSelfPermission(
                requireActivity(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
            && ActivityCompat.checkSelfPermission(
                requireActivity(),
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }
        // 기기의 위치에 관한 정기 업데이트를 요청하는 메서드 실행
        // 지정한 루퍼 스레드(Looper.myLooper())에서 콜백(mLocationCallback)으로 위치 업데이트를 요청
        mFusedLocationProviderClient.requestLocationUpdates(
            mLocationRequest,
            mLocationCallback,
            Looper.myLooper()
        )
    }

    // 시스템으로 부터 위치 정보를 콜백으로 받음
    private val mLocationCallback = object : LocationCallback() {
        override fun onLocationResult(locationResult: LocationResult) {
            // 시스템에서 받은 location 정보를 onLocationChanged()에 전달
            locationResult.lastLocation
            onLocationChanged(locationResult.lastLocation!!)
            currentPosition = LatLng(mLastLocation.latitude, mLastLocation.longitude)
            showPlaceInformation(currentPosition);
        }

    }

    fun onLocationChanged(location: Location) {
        mLastLocation = location


    }

    override fun onPlacesFailure(e: PlacesException?) {
        ToastMare().ToastShort(requireContext(), "잠시후 다시 시도해주세요")
    }

    override fun onPlacesStart() {


    }

    override fun onPlacesSuccess(places: MutableList<Place>?) {
        requireActivity().runOnUiThread(Runnable {

            for (place in places!!) {
                val latLng = LatLng(place.latitude, place.longitude)

                val markerSnippet: String = getCurrentAddress(latLng)
                val markerOptions = MarkerOptions()
                markerOptions.position(latLng)
                markerOptions.title(place.name)
                markerOptions.snippet(markerSnippet)
                val item = mMap.addMarker(markerOptions)
                previousMarker.add(item!!)


            }

            //중복 마커 제거
            val hashSet = HashSet<Marker>()
            hashSet.addAll(previousMarker)
            previousMarker.clear()
            previousMarker.addAll(hashSet)
        })
    }

    override fun onPlacesFinished() {

    }

    fun showPlaceInformation(location: LatLng) {
        mMap.clear() //지도 클리어
        NRPlaces.Builder()
            .listener(this)
            .key("AIzaSyAY6EjXB4WtfXJXIQzj8Hp3QHJmGXoyCvI")
            .latlng(location.latitude, location.longitude) //현재 위치
            .radius(1000) //5000 미터 내에서 검색
            .type(PlaceType.CAFE) //음식점
            .build()
            .execute()
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 15f))
    }

    private fun getCurrentAddress(latlng: LatLng): String {

        //지오코더... GPS를 주소로 변환
        val geocoder = Geocoder(requireContext(), Locale.getDefault())
        val addresses: List<Address>? = try {
            geocoder.getFromLocation(
                latlng.latitude,
                latlng.longitude,
                1
            )
        } catch (ioException: IOException) {
            //네트워크 문제
            return "지오코더 서비스 사용불가"
        } catch (illegalArgumentException: IllegalArgumentException) {
            return "잘못된 GPS 좌표"
        }
        return if (addresses == null || addresses.isEmpty()) {
            "주소 미발견"
        } else {
            val address: Address = addresses[0]
            address.getAddressLine(0).toString()
        }
    }

}