package com.example.cachenetworkdb2024.fragment

import com.example.cachenetworkdb2024.model.VideoDomainModel

class VideoClickListener(val block: (VideoDomainModel) -> Unit) {
    /**
     * Called when a video is clicked
     *
     * @param video the video that was clicked
     */
    fun onClick(video: VideoDomainModel) = block(video)
}