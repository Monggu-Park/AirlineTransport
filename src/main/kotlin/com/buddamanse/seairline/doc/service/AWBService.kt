package com.buddamanse.seairline.doc.service

interface AWBService {
    fun getAWBdoc(owner: String, docId: String): Result<AWBdoc>
}