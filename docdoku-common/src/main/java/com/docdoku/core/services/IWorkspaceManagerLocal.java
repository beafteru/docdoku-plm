/*
 * DocDoku, Professional Open Source
 * Copyright 2006 - 2017 DocDoku SARL
 *
 * This file is part of DocDokuPLM.
 *
 * DocDokuPLM is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * DocDokuPLM is distributed in the hope that it will be useful,  
 * but WITHOUT ANY WARRANTY; without even the implied warranty of  
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the  
 * GNU Affero General Public License for more details.  
 *  
 * You should have received a copy of the GNU Affero General Public License  
 * along with DocDokuPLM.  If not, see <http://www.gnu.org/licenses/>.  
 */

package com.docdoku.core.services;

import com.docdoku.core.admin.WorkspaceOptions;
import com.docdoku.core.common.Account;
import com.docdoku.core.common.Workspace;
import com.docdoku.core.exceptions.*;

/**
 *
 * @author Morgan Guimard
 * @version 2.0, 13/09/14
 * @since   V1.0
 */
public interface IWorkspaceManagerLocal {
    long getDiskUsageInWorkspace(String workspaceId) throws AccountNotFoundException;
    void deleteWorkspace(String workspaceId);
    Workspace changeAdmin(String workspaceId, String login) throws WorkspaceNotFoundException, AccountNotFoundException, UserNotFoundException, UserNotActiveException, AccessRightException, WorkspaceNotEnabledException;
    Workspace enableWorkspace(String workspaceId, boolean enabled) throws WorkspaceNotFoundException;
    Workspace getWorkspace(String pWorkspaceId) throws WorkspaceNotFoundException, AccountNotFoundException;
    Workspace createWorkspace(String pID, Account pAdmin, String pDescription, boolean pFolderLocked) throws FolderAlreadyExistsException, UserAlreadyExistsException, WorkspaceAlreadyExistsException, CreationException,  NotAllowedException;
    Workspace updateWorkspace(String workspaceId, String description, boolean isFolderLocked) throws AccessRightException, AccountNotFoundException, WorkspaceNotFoundException;
    void updateWorkspaceOptions(WorkspaceOptions pWorkspaceOptions) throws AccessRightException, AccountNotFoundException;
    WorkspaceOptions getWorkspaceOptions(String workspaceId) throws AccountNotFoundException, WorkspaceNotFoundException;

}
