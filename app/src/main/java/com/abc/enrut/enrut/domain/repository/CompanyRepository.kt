package com.abc.enrut.enrut.domain.repository


import com.abc.enrut.enrut.domain.model.Company
import com.abc.enrut.enrut.core.Constants

import retrofit2.http.GET
import retrofit2.http.Headers

interface CompanyRepository {
    @Headers("Authorization: Bearer eyJraWQiOiJYVno4TmVCUUZhWHNUWTFrMlNPWW1KR1wvQTJLRWtjUnRXekpCOTAyelwvM0E9IiwiYWxnIjoiUlMyNTYifQ.eyJzdWIiOiJmMWRiNDU4MC0zMDkxLTcwZDktY2Y4NS1iY2ZiZTY5MzY3NjgiLCJpc3MiOiJodHRwczpcL1wvY29nbml0by1pZHAudXMtZWFzdC0yLmFtYXpvbmF3cy5jb21cL3VzLWVhc3QtMl9xRmEybHV5eTIiLCJjb2duaXRvOnVzZXJuYW1lIjoiZjFkYjQ1ODAtMzA5MS03MGQ5LWNmODUtYmNmYmU2OTM2NzY4Iiwib3JpZ2luX2p0aSI6ImU3OTAxZGJkLTI3MTctNDk5Zi05NGY0LWFkMmVmOTUwMzJhNyIsImF1ZCI6IjJscjE2b3A5Y3RjaDI5Y2FxMWtkbmEyNG50IiwiZXZlbnRfaWQiOiI2MDJmNTJmNi04MDQ2LTQ2MTctYmRmNS05ZjcwOWE0YjNjYjYiLCJjdXN0b206dXNlclJvbGUiOiJTVVBFUl9BRE1JTiIsInRva2VuX3VzZSI6ImlkIiwiYXV0aF90aW1lIjoxNzQxODk0MDM2LCJleHAiOjE3NDE4OTc2MzYsImlhdCI6MTc0MTg5NDAzNiwianRpIjoiNDMyOTExMWItNTk3MC00NzI5LTgwMWEtMmMyYTRmZTM4NzRkIiwiZW1haWwiOiJhbmRlcnNvbmcuOTAxMkBnbWFpbC5jb20ifQ.TdMt-Gdw0PV15onWGMsXcziiAyW8CBVbV6ebtdkmKT9cKP1ktmkSMXuf9VActB-zjuj_buA_Gn0aVgL88lRtMSd0Xkn-RAZY0ebvk4XV8WJkRDU7AePj-1jifk1CZSc-oIWgNjdCTIVP8X-Bk0brek5uzx5mrPrztpszMwTLPNEgyjVB0IcfXZT9Mfd3W2Aot1pMno0I9s6L-ThiI7bUGHg0ojQQ6qhOS2uOA0pmGuf8b9ZJ7xrJCoTcTzj1GIHShauXJ1hXHROBrVEaT1OSWQS7r-JjL8kDk38uT_Yp9AXrZpUufpbgzzXIHZSykKLXavIxozSQlyjzWLIz8lTI0Q")
    @GET(Constants.companiesEndpoint)
    suspend fun queryCompanies(): MutableList<Company>
}