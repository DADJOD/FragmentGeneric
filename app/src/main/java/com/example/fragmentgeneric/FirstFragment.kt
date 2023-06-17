package com.example.fragmentgeneric

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.jetbrains.annotations.Nullable


class FirstFragment : Fragment() {
    @Nullable
    override fun onCreateView(
        inflater: LayoutInflater,
        @Nullable container: ViewGroup?,
        @Nullable savedInstanceState: Bundle?,
    ): View {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }
}