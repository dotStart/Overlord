/*
 * Copyright (C) 2020 Johannes Donath <johannesd@torchmind.com>
 * and other copyright owners as documented in the project's IP log.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package tv.dotstart.overlord.server.model.v1.security

import kotlinx.dnq.query.toList
import org.joda.time.DateTime
import tv.dotstart.overlord.server.entity.security.Session
import tv.dotstart.overlord.server.model.v1.audit.AuditLogEntry

/**
 * Provides information on a given session.
 *
 * @author [Johannes Donath](mailto:johannesd@torchmind.com)
 * @date 04/07/2020
 */
data class SessionInfo(
    val id: String,
    val auditLog: List<AuditLogEntry>,
    val createdAt: DateTime,
    val updatedAt: DateTime,
    val expiresAt: DateTime) {

  constructor(entity: Session) : this(
      entity.xdId,
      entity.auditLog.toList().map(::AuditLogEntry),
      entity.createdAt,
      entity.updatedAt,
      entity.expiresAt)
}
