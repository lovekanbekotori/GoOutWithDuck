/*
 * Copyright 2021 headuck (https://blog.headuck.com/)
 *
 * This file is part of GoOutWithDuck
 *
 * GoOutWithDuck is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * GoOutWithDuck is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with GoOutWithDuck. If not, see <http://www.gnu.org/licenses/>.
 *
 */

package com.headuck.app.gooutwithduck.usecases;


import com.github.michaelbull.result.Result

import com.headuck.app.gooutwithduck.data.VisitHistoryRepository;
import com.headuck.app.gooutwithduck.workers.ExitCheckWorkerUtil

import javax.inject.Inject;
import javax.inject.Singleton;
import java.lang.Exception
import java.util.*

/**
 * Logic to leave venue
 */
@Singleton
class LeaveVenueUseCase @Inject constructor(private val visitHistoryRepository: VisitHistoryRepository,
                                            private val exitCheckWorkerUtil: ExitCheckWorkerUtil) {

    suspend fun leaveVenue(visitHistoryId: Int, time: Calendar):Result<Boolean, Exception> {
        exitCheckWorkerUtil.cancelExitSchedlue(visitHistoryId)
        return visitHistoryRepository.leaveVenue(visitHistoryId, time)
    }
}