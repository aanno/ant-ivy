/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
package org.apache.ivy.plugins.parser.m2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ivy.util.StringUtils;

public class PomWriterOptions {

    private String[] confs;
    
    private String licenseHeader;
    
    private ConfigurationScopeMapping mapping;
    
    private boolean printIvyInfo = true;
    
    private String artifactName;
    
    private String artifactPackaging;
    
    private List/*<ExtraDependency>*/ extraDependencies = new ArrayList();

    public String[] getConfs() {
        return confs;
    }

    public PomWriterOptions setConfs(String[] confs) {
        this.confs = confs;
        return this;
    }

    public String getLicenseHeader() {
        return licenseHeader;
    }

    public PomWriterOptions setLicenseHeader(String licenseHeader) {
        this.licenseHeader = licenseHeader;
        return this;
    }

    public ConfigurationScopeMapping getMapping() {
        return mapping;
    }

    public PomWriterOptions setMapping(ConfigurationScopeMapping mapping) {
        this.mapping = mapping;
        return this;
    }

    public boolean isPrintIvyInfo() {
        return printIvyInfo;
    }

    public PomWriterOptions setPrintIvyInfo(boolean printIvyInfo) {
        this.printIvyInfo = printIvyInfo;
        return this;
    }
    
    public List/*<ExtraDependency>*/ getExtraDependencies() {
        return extraDependencies;
    }

    public PomWriterOptions setExtraDependencies(List/*<ExtraDependency>*/ extraDependencies) {
        this.extraDependencies = extraDependencies;
        return this;
    }
    
    public String getArtifactName() {
        return artifactName;
    }

    public PomWriterOptions setArtifactName(String artifactName) {
        this.artifactName = artifactName;
        return this;
    }

    public String getArtifactPackaging() {
        return artifactPackaging;
    }

    public PomWriterOptions setArtifactPackaging(String artifactPackaging) {
        this.artifactPackaging = artifactPackaging;
        return this;
    }

    public static class ConfigurationScopeMapping {
        private Map/*<String,String>*/ scopes;
        
        public ConfigurationScopeMapping(Map/*<String,String>*/ scopesMapping) {
            this.scopes = new HashMap(scopesMapping);
        }

        /**
         * Returns the scope mapped to the given configuration array.
         * 
         * @param confs the configurations for which the scope should be returned
         * @return the scope to which the conf is mapped
         */
        public String getScope(String[] confs) {
            return (String) scopes.get(StringUtils.join(confs, ", "));
        }
        public boolean isOptional(String[] confs) {
            return getScope(confs) == null;
        }
    }

    public static class ExtraDependency {
            private String group;
            private String artifact;
            private String version;
            private String scope;
            private boolean optional;
            
            public ExtraDependency(String group, String artifact, String version, String scope, boolean optional) {
                this.group = group;
                this.artifact = artifact;
                this.version = version;
                this.scope = scope;
                this.optional = optional;
            }
            
            public String getGroup() {
                return group;
            }
            public String getArtifact() {
                return artifact;
            }
            public String getVersion() {
                return version;
            }
            public String getScope() {
                return scope;
            }
            public boolean isOptional() {
                return optional;
            }
        }

    
}
