package com.dist.imobile

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dist.imobile.databinding.ActivityMapBinding
import com.supermap.data.Environment
import com.supermap.data.Workspace
import com.supermap.data.WorkspaceConnectionInfo
import com.supermap.data.WorkspaceType
import com.supermap.mapping.MapControl
import com.supermap.mapping.MapView
import com.therouter.TheRouter
import com.therouter.router.Route


@Route(path = "map")
class MapActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMapBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        TheRouter.inject(this)
        initLicense()
        binding = ActivityMapBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        val rootPath =  android.os.Environment.getExternalStorageDirectory().absolutePath
        //打开工作空间
        val m_workspace = Workspace()
        val info = WorkspaceConnectionInfo()
        info.server = "$rootPath/SuperMap/SampleData/GeometryInfo/World.smwu"
        info.type = WorkspaceType.SMWU
        m_workspace.open(info)

        val mapControl = binding.mapView.mapControl
        mapControl.map.workspace = m_workspace

        //打开工作空间中的第二幅地图

        //打开工作空间中的第二幅地图
        val mapName = m_workspace.maps[1]
        mapControl.map.open(mapName)
        mapControl.map.refresh()
    }

    private fun initLicense() {
        val rootPath =  android.os.Environment.getExternalStorageDirectory().absolutePath

        //设置许可文件路径（默认路径“/SuperMap/license/”）
        Environment.setLicensePath("$rootPath/SuperMap/license/")

        //组件功能必须在Environment初始化之后才能调用
        Environment.initialization(this)

    }
}