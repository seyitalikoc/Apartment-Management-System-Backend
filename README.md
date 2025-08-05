Repository: seyitalikoc/apartment-management-system-backend
Files analyzed: 161

Estimated tokens: 70.9k

Directory structure:
└── seyitalikoc-apartment-management-system-backend/
    ├── ams.iml
    ├── HELP.md
    ├── mvnw
    ├── mvnw.cmd
    ├── pom.xml
    ├── src/
    │   ├── main/
    │   │   ├── java/
    │   │   │   └── com/
    │   │   │       └── seyitkoc/
    │   │   │           ├── AmsApplication.java
    │   │   │           ├── common/
    │   │   │           │   ├── config/
    │   │   │           │   │   ├── ApplicationConfig.java
    │   │   │           │   │   ├── HttpsRedirectConfig.java
    │   │   │           │   │   └── SecurityConfig.java
    │   │   │           │   ├── dto/
    │   │   │           │   │   └── ApiResponse.java
    │   │   │           │   ├── exception/
    │   │   │           │   │   ├── ApplicationException.java
    │   │   │           │   │   ├── ErrorMessage.java
    │   │   │           │   │   └── MessageType.java
    │   │   │           │   ├── handler/
    │   │   │           │   │   ├── ApiError.java
    │   │   │           │   │   ├── Exception.java
    │   │   │           │   │   └── GlobalExceptionHandler.java
    │   │   │           │   └── security/
    │   │   │           │       ├── JwtAuthenticationFilter.java
    │   │   │           │       └── JwtTokenService.java
    │   │   │           ├── controller/
    │   │   │           │   ├── AnnouncementController.java
    │   │   │           │   ├── ApartmentAccountController.java
    │   │   │           │   ├── ApartmentController.java
    │   │   │           │   ├── ApartmentDebtsController.java
    │   │   │           │   ├── AuthController.java
    │   │   │           │   ├── BuildingAccountController.java
    │   │   │           │   ├── BuildingController.java
    │   │   │           │   ├── DebtController.java
    │   │   │           │   ├── DueController.java
    │   │   │           │   ├── PollController.java
    │   │   │           │   ├── TransactionController.java
    │   │   │           │   ├── UserController.java
    │   │   │           │   └── VoteController.java
    │   │   │           ├── dto/
    │   │   │           │   ├── announcement/
    │   │   │           │   │   ├── DtoAnnouncement.java
    │   │   │           │   │   └── DtoAnnouncementIU.java
    │   │   │           │   ├── apartment/
    │   │   │           │   │   └── DtoApartment.java
    │   │   │           │   ├── apartmentAccount/
    │   │   │           │   │   └── DtoApartmentAccount.java
    │   │   │           │   ├── apartmentDebts/
    │   │   │           │   │   └── DtoApartmentDebts.java
    │   │   │           │   ├── auth/
    │   │   │           │   │   ├── DtoAuth.java
    │   │   │           │   │   ├── DtoAuthEmailUpdate.java
    │   │   │           │   │   ├── DtoAuthPasswordUpdate.java
    │   │   │           │   │   └── LoginRequest.java
    │   │   │           │   ├── building/
    │   │   │           │   │   ├── DtoBuilding.java
    │   │   │           │   │   └── DtoBuildingIU.java
    │   │   │           │   ├── buildingAccount/
    │   │   │           │   │   ├── DtoBuildingAccount.java
    │   │   │           │   │   └── DtoBuildingAccountIU.java
    │   │   │           │   ├── debt/
    │   │   │           │   │   ├── DtoDebt.java
    │   │   │           │   │   └── DtoDebtIU.java
    │   │   │           │   ├── due/
    │   │   │           │   │   ├── DtoDue.java
    │   │   │           │   │   └── DtoDueUpdate.java
    │   │   │           │   ├── poll/
    │   │   │           │   │   ├── DtoPoll.java
    │   │   │           │   │   ├── DtoPollIU.java
    │   │   │           │   │   ├── DtoPollResult.java
    │   │   │           │   │   └── DtoPollResultItem.java
    │   │   │           │   ├── pollOption/
    │   │   │           │   │   └── DtoPollOption.java
    │   │   │           │   ├── transaction/
    │   │   │           │   │   ├── DtoTransaction.java
    │   │   │           │   │   └── DtoTransactionIU.java
    │   │   │           │   └── user/
    │   │   │           │       ├── DtoUser.java
    │   │   │           │       ├── DtoUserCreate.java
    │   │   │           │       └── DtoUserUpdate.java
    │   │   │           ├── entity/
    │   │   │           │   ├── Announcement.java
    │   │   │           │   ├── Apartment.java
    │   │   │           │   ├── ApartmentAccount.java
    │   │   │           │   ├── ApartmentAnnouncement.java
    │   │   │           │   ├── ApartmentDebts.java
    │   │   │           │   ├── Auth.java
    │   │   │           │   ├── Building.java
    │   │   │           │   ├── BuildingAccount.java
    │   │   │           │   ├── Debt.java
    │   │   │           │   ├── Due.java
    │   │   │           │   ├── Poll.java
    │   │   │           │   ├── PollOption.java
    │   │   │           │   ├── User.java
    │   │   │           │   ├── Vote.java
    │   │   │           │   └── transaction/
    │   │   │           │       ├── Expense.java
    │   │   │           │       ├── Income.java
    │   │   │           │       └── Transaction.java
    │   │   │           ├── enums/
    │   │   │           │   ├── AccountType.java
    │   │   │           │   ├── AuthRole.java
    │   │   │           │   ├── DebtType.java
    │   │   │           │   ├── ExpenseType.java
    │   │   │           │   └── IncomeType.java
    │   │   │           ├── mapper/
    │   │   │           │   ├── AnnouncementMapper.java
    │   │   │           │   ├── ApartmentAccountMapper.java
    │   │   │           │   ├── ApartmentDebtsMapper.java
    │   │   │           │   ├── ApartmentMapper.java
    │   │   │           │   ├── AuthMapper.java
    │   │   │           │   ├── BuildingAccountMapper.java
    │   │   │           │   ├── BuildingMapper.java
    │   │   │           │   ├── DebtMapper.java
    │   │   │           │   ├── DueMapper.java
    │   │   │           │   ├── PollMapper.java
    │   │   │           │   ├── PollOptionMapper.java
    │   │   │           │   ├── TransactionMapper.java
    │   │   │           │   └── UserMapper.java
    │   │   │           ├── repository/
    │   │   │           │   ├── AnnouncementRepository.java
    │   │   │           │   ├── ApartmentAccountRepository.java
    │   │   │           │   ├── ApartmentAnnouncementRepository.java
    │   │   │           │   ├── ApartmentDebtsRepository.java
    │   │   │           │   ├── ApartmentRepository.java
    │   │   │           │   ├── AuthRepository.java
    │   │   │           │   ├── BuildingAccountRepository.java
    │   │   │           │   ├── BuildingRepository.java
    │   │   │           │   ├── DebtRepository.java
    │   │   │           │   ├── DueRepository.java
    │   │   │           │   ├── PollOptionRepository.java
    │   │   │           │   ├── PollRepository.java
    │   │   │           │   ├── TransactionRepository.java
    │   │   │           │   ├── UserRepository.java
    │   │   │           │   └── VoteRepository.java
    │   │   │           ├── service/
    │   │   │           │   ├── IAnnouncementService.java
    │   │   │           │   ├── IApartmentAccountService.java
    │   │   │           │   ├── IApartmentAnnouncementService.java
    │   │   │           │   ├── IApartmentDebtsService.java
    │   │   │           │   ├── IApartmentService.java
    │   │   │           │   ├── IAuthService.java
    │   │   │           │   ├── IBuildingAccountService.java
    │   │   │           │   ├── IBuildingService.java
    │   │   │           │   ├── IDebtService.java
    │   │   │           │   ├── IDueService.java
    │   │   │           │   ├── IPollOptionService.java
    │   │   │           │   ├── IPollService.java
    │   │   │           │   ├── ITransactionService.java
    │   │   │           │   ├── IUserService.java
    │   │   │           │   ├── IVoteService.java
    │   │   │           │   ├── base/
    │   │   │           │   │   ├── AnnouncementBaseService.java
    │   │   │           │   │   ├── ApartmentAccountBaseService.java
    │   │   │           │   │   ├── ApartmentBaseService.java
    │   │   │           │   │   ├── ApartmentDebtsBaseService.java
    │   │   │           │   │   ├── BuildingAccountBaseService.java
    │   │   │           │   │   ├── BuildingBaseService.java
    │   │   │           │   │   ├── DebtBaseService.java
    │   │   │           │   │   ├── DueBaseService.java
    │   │   │           │   │   ├── PollBaseService.java
    │   │   │           │   │   ├── PollOptionBaseService.java
    │   │   │           │   │   └── TransactionBaseService.java
    │   │   │           │   └── impl/
    │   │   │           │       ├── AnnouncementServiceImpl.java
    │   │   │           │       ├── ApartmentAccountServiceImpl.java
    │   │   │           │       ├── ApartmentAnnouncementServiceImpl.java
    │   │   │           │       ├── ApartmentDebtsServiceImpl.java
    │   │   │           │       ├── ApartmentServiceImpl.java
    │   │   │           │       ├── AuthServiceImpl.java
    │   │   │           │       ├── BuildingAccountServiceImpl.java
    │   │   │           │       ├── BuildingServiceImpl.java
    │   │   │           │       ├── DebtServiceImpl.java
    │   │   │           │       ├── DueServiceImpl.java
    │   │   │           │       ├── PollOptionServiceImpl.java
    │   │   │           │       ├── PollServiceImpl.java
    │   │   │           │       ├── TransactionServiceImpl.java
    │   │   │           │       ├── UserServiceImpl.java
    │   │   │           │       └── VoteServiceImpl.java
    │   │   │           └── specification/
    │   │   │               ├── AnnouncementSpecification.java
    │   │   │               ├── ApartmentDebtsSpecification.java
    │   │   │               ├── BuildingAccountSpecification.java
    │   │   │               ├── DebtSpecification.java
    │   │   │               ├── PollSpecification.java
    │   │   │               └── TransactionSpecification.java
    │   │   └── resources/
    │   │       ├── application.properties
    │   │       ├── keystore.p12
    │   │       └── META-INF/
    │   │           └── MANIFEST.MF
    │   └── test/
    │       └── java/
    │           └── com/
    │               └── seyitkoc/
    │                   ├── service/
    │                   │   └── impl/
    │                   │       └── AnnouncementServiceImplTest.java
    │                   └── starter/
    │                       └── AmsApplicationTests.java
    └── .mvn/
        └── wrapper/
            └── maven-wrapper.properties


================================================
FILE: ams.iml
================================================
<?xml version="1.0" encoding="UTF-8"?>
<module version="4">
  <component name="CheckStyle-IDEA-Module" serialisationVersion="2">
    <option name="activeLocationsIds" />
  </component>
  <component name="FacetManager">
    <facet type="jpa" name="JPA">
      <configuration>
        <setting name="validation-enabled" value="true" />
        <setting name="provider-name" value="Hibernate" />
        <datasource-mapping>
          <factory-entry name="ams" value="f358b825-082c-4048-a99e-49762c4541ae" />
          <factory-entry name="entityManagerFactory" value="f358b825-082c-4048-a99e-49762c4541ae" />
        </datasource-mapping>
        <naming-strategy-map />
      </configuration>
    </facet>
  </component>
</module>


================================================
FILE: HELP.md
================================================
# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/3.4.6/maven-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.4.6/maven-plugin/build-image.html)
* [Spring Configuration Processor](https://docs.spring.io/spring-boot/3.4.6/specification/configuration-metadata/annotation-processor.html)
* [Spring Data JPA](https://docs.spring.io/spring-boot/3.4.6/reference/data/sql.html#data.sql.jpa-and-spring-data)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/3.4.6/reference/using/devtools.html)
* [JDBC API](https://docs.spring.io/spring-boot/3.4.6/reference/data/sql.html)
* [Spring Security](https://docs.spring.io/spring-boot/3.4.6/reference/web/spring-security.html)
* [Spring Web](https://docs.spring.io/spring-boot/3.4.6/reference/web/servlet.html)

### Guides

The following guides illustrate how to use some features concretely:

* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Accessing Relational Data using JDBC with Spring](https://spring.io/guides/gs/relational-data-access/)
* [Managing Transactions](https://spring.io/guides/gs/managing-transactions/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)
* [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
* [Spring Boot and OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)
* [Authenticating a User with LDAP](https://spring.io/guides/gs/authenticating-ldap/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

### Maven Parent overrides

Due to Maven's design, elements are inherited from the parent POM to the project POM.
While most of the inheritance is fine, it also inherits unwanted elements like `<license>` and `<developers>` from the
parent.
To prevent this, the project POM contains empty overrides for these elements.
If you manually switch to a different parent and actually want the inheritance, you need to remove those overrides.




================================================
FILE: mvnw
================================================
#!/bin/sh
# ----------------------------------------------------------------------------
# Licensed to the Apache Software Foundation (ASF) under one
# or more contributor license agreements.  See the NOTICE file
# distributed with this work for additional information
# regarding copyright ownership.  The ASF licenses this file
# to you under the Apache License, Version 2.0 (the
# "License"); you may not use this file except in compliance
# with the License.  You may obtain a copy of the License at
#
#    http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing,
# software distributed under the License is distributed on an
# "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
# KIND, either express or implied.  See the License for the
# specific language governing permissions and limitations
# under the License.
# ----------------------------------------------------------------------------

# ----------------------------------------------------------------------------
# Apache Maven Wrapper startup batch script, version 3.3.2
#
# Optional ENV vars
# -----------------
#   JAVA_HOME - location of a JDK home dir, required when download maven via java source
#   MVNW_REPOURL - repo url base for downloading maven distribution
#   MVNW_USERNAME/MVNW_PASSWORD - user and password for downloading maven
#   MVNW_VERBOSE - true: enable verbose log; debug: trace the mvnw script; others: silence the output
# ----------------------------------------------------------------------------

set -euf
[ "${MVNW_VERBOSE-}" != debug ] || set -x

# OS specific support.
native_path() { printf %s\\n "$1"; }
case "$(uname)" in
CYGWIN* | MINGW*)
  [ -z "${JAVA_HOME-}" ] || JAVA_HOME="$(cygpath --unix "$JAVA_HOME")"
  native_path() { cygpath --path --windows "$1"; }
  ;;
esac

# set JAVACMD and JAVACCMD
set_java_home() {
  # For Cygwin and MinGW, ensure paths are in Unix format before anything is touched
  if [ -n "${JAVA_HOME-}" ]; then
    if [ -x "$JAVA_HOME/jre/sh/java" ]; then
      # IBM's JDK on AIX uses strange locations for the executables
      JAVACMD="$JAVA_HOME/jre/sh/java"
      JAVACCMD="$JAVA_HOME/jre/sh/javac"
    else
      JAVACMD="$JAVA_HOME/bin/java"
      JAVACCMD="$JAVA_HOME/bin/javac"

      if [ ! -x "$JAVACMD" ] || [ ! -x "$JAVACCMD" ]; then
        echo "The JAVA_HOME environment variable is not defined correctly, so mvnw cannot run." >&2
        echo "JAVA_HOME is set to \"$JAVA_HOME\", but \"\$JAVA_HOME/bin/java\" or \"\$JAVA_HOME/bin/javac\" does not exist." >&2
        return 1
      fi
    fi
  else
    JAVACMD="$(
      'set' +e
      'unset' -f command 2>/dev/null
      'command' -v java
    )" || :
    JAVACCMD="$(
      'set' +e
      'unset' -f command 2>/dev/null
      'command' -v javac
    )" || :

    if [ ! -x "${JAVACMD-}" ] || [ ! -x "${JAVACCMD-}" ]; then
      echo "The java/javac command does not exist in PATH nor is JAVA_HOME set, so mvnw cannot run." >&2
      return 1
    fi
  fi
}

# hash string like Java String::hashCode
hash_string() {
  str="${1:-}" h=0
  while [ -n "$str" ]; do
    char="${str%"${str#?}"}"
    h=$(((h * 31 + $(LC_CTYPE=C printf %d "'$char")) % 4294967296))
    str="${str#?}"
  done
  printf %x\\n $h
}

verbose() { :; }
[ "${MVNW_VERBOSE-}" != true ] || verbose() { printf %s\\n "${1-}"; }

die() {
  printf %s\\n "$1" >&2
  exit 1
}

trim() {
  # MWRAPPER-139:
  #   Trims trailing and leading whitespace, carriage returns, tabs, and linefeeds.
  #   Needed for removing poorly interpreted newline sequences when running in more
  #   exotic environments such as mingw bash on Windows.
  printf "%s" "${1}" | tr -d '[:space:]'
}

# parse distributionUrl and optional distributionSha256Sum, requires .mvn/wrapper/maven-wrapper.properties
while IFS="=" read -r key value; do
  case "${key-}" in
  distributionUrl) distributionUrl=$(trim "${value-}") ;;
  distributionSha256Sum) distributionSha256Sum=$(trim "${value-}") ;;
  esac
done <"${0%/*}/.mvn/wrapper/maven-wrapper.properties"
[ -n "${distributionUrl-}" ] || die "cannot read distributionUrl property in ${0%/*}/.mvn/wrapper/maven-wrapper.properties"

case "${distributionUrl##*/}" in
maven-mvnd-*bin.*)
  MVN_CMD=mvnd.sh _MVNW_REPO_PATTERN=/maven/mvnd/
  case "${PROCESSOR_ARCHITECTURE-}${PROCESSOR_ARCHITEW6432-}:$(uname -a)" in
  *AMD64:CYGWIN* | *AMD64:MINGW*) distributionPlatform=windows-amd64 ;;
  :Darwin*x86_64) distributionPlatform=darwin-amd64 ;;
  :Darwin*arm64) distributionPlatform=darwin-aarch64 ;;
  :Linux*x86_64*) distributionPlatform=linux-amd64 ;;
  *)
    echo "Cannot detect native platform for mvnd on $(uname)-$(uname -m), use pure java version" >&2
    distributionPlatform=linux-amd64
    ;;
  esac
  distributionUrl="${distributionUrl%-bin.*}-$distributionPlatform.zip"
  ;;
maven-mvnd-*) MVN_CMD=mvnd.sh _MVNW_REPO_PATTERN=/maven/mvnd/ ;;
*) MVN_CMD="mvn${0##*/mvnw}" _MVNW_REPO_PATTERN=/org/apache/maven/ ;;
esac

# apply MVNW_REPOURL and calculate MAVEN_HOME
# maven home pattern: ~/.m2/wrapper/dists/{apache-maven-<version>,maven-mvnd-<version>-<platform>}/<hash>
[ -z "${MVNW_REPOURL-}" ] || distributionUrl="$MVNW_REPOURL$_MVNW_REPO_PATTERN${distributionUrl#*"$_MVNW_REPO_PATTERN"}"
distributionUrlName="${distributionUrl##*/}"
distributionUrlNameMain="${distributionUrlName%.*}"
distributionUrlNameMain="${distributionUrlNameMain%-bin}"
MAVEN_USER_HOME="${MAVEN_USER_HOME:-${HOME}/.m2}"
MAVEN_HOME="${MAVEN_USER_HOME}/wrapper/dists/${distributionUrlNameMain-}/$(hash_string "$distributionUrl")"

exec_maven() {
  unset MVNW_VERBOSE MVNW_USERNAME MVNW_PASSWORD MVNW_REPOURL || :
  exec "$MAVEN_HOME/bin/$MVN_CMD" "$@" || die "cannot exec $MAVEN_HOME/bin/$MVN_CMD"
}

if [ -d "$MAVEN_HOME" ]; then
  verbose "found existing MAVEN_HOME at $MAVEN_HOME"
  exec_maven "$@"
fi

case "${distributionUrl-}" in
*?-bin.zip | *?maven-mvnd-?*-?*.zip) ;;
*) die "distributionUrl is not valid, must match *-bin.zip or maven-mvnd-*.zip, but found '${distributionUrl-}'" ;;
esac

# prepare tmp dir
if TMP_DOWNLOAD_DIR="$(mktemp -d)" && [ -d "$TMP_DOWNLOAD_DIR" ]; then
  clean() { rm -rf -- "$TMP_DOWNLOAD_DIR"; }
  trap clean HUP INT TERM EXIT
else
  die "cannot create temp dir"
fi

mkdir -p -- "${MAVEN_HOME%/*}"

# Download and Install Apache Maven
verbose "Couldn't find MAVEN_HOME, downloading and installing it ..."
verbose "Downloading from: $distributionUrl"
verbose "Downloading to: $TMP_DOWNLOAD_DIR/$distributionUrlName"

# select .zip or .tar.gz
if ! command -v unzip >/dev/null; then
  distributionUrl="${distributionUrl%.zip}.tar.gz"
  distributionUrlName="${distributionUrl##*/}"
fi

# verbose opt
__MVNW_QUIET_WGET=--quiet __MVNW_QUIET_CURL=--silent __MVNW_QUIET_UNZIP=-q __MVNW_QUIET_TAR=''
[ "${MVNW_VERBOSE-}" != true ] || __MVNW_QUIET_WGET='' __MVNW_QUIET_CURL='' __MVNW_QUIET_UNZIP='' __MVNW_QUIET_TAR=v

# normalize http auth
case "${MVNW_PASSWORD:+has-password}" in
'') MVNW_USERNAME='' MVNW_PASSWORD='' ;;
has-password) [ -n "${MVNW_USERNAME-}" ] || MVNW_USERNAME='' MVNW_PASSWORD='' ;;
esac

if [ -z "${MVNW_USERNAME-}" ] && command -v wget >/dev/null; then
  verbose "Found wget ... using wget"
  wget ${__MVNW_QUIET_WGET:+"$__MVNW_QUIET_WGET"} "$distributionUrl" -O "$TMP_DOWNLOAD_DIR/$distributionUrlName" || die "wget: Failed to fetch $distributionUrl"
elif [ -z "${MVNW_USERNAME-}" ] && command -v curl >/dev/null; then
  verbose "Found curl ... using curl"
  curl ${__MVNW_QUIET_CURL:+"$__MVNW_QUIET_CURL"} -f -L -o "$TMP_DOWNLOAD_DIR/$distributionUrlName" "$distributionUrl" || die "curl: Failed to fetch $distributionUrl"
elif set_java_home; then
  verbose "Falling back to use Java to download"
  javaSource="$TMP_DOWNLOAD_DIR/Downloader.java"
  targetZip="$TMP_DOWNLOAD_DIR/$distributionUrlName"
  cat >"$javaSource" <<-END
	public class Downloader extends java.net.Authenticator
	{
	  protected java.net.PasswordAuthentication getPasswordAuthentication()
	  {
	    return new java.net.PasswordAuthentication( System.getenv( "MVNW_USERNAME" ), System.getenv( "MVNW_PASSWORD" ).toCharArray() );
	  }
	  public static void main( String[] args ) throws Exception
	  {
	    setDefault( new Downloader() );
	    java.nio.file.Files.copy( java.net.URI.create( args[0] ).toURL().openStream(), java.nio.file.Paths.get( args[1] ).toAbsolutePath().normalize() );
	  }
	}
	END
  # For Cygwin/MinGW, switch paths to Windows format before running javac and java
  verbose " - Compiling Downloader.java ..."
  "$(native_path "$JAVACCMD")" "$(native_path "$javaSource")" || die "Failed to compile Downloader.java"
  verbose " - Running Downloader.java ..."
  "$(native_path "$JAVACMD")" -cp "$(native_path "$TMP_DOWNLOAD_DIR")" Downloader "$distributionUrl" "$(native_path "$targetZip")"
fi

# If specified, validate the SHA-256 sum of the Maven distribution zip file
if [ -n "${distributionSha256Sum-}" ]; then
  distributionSha256Result=false
  if [ "$MVN_CMD" = mvnd.sh ]; then
    echo "Checksum validation is not supported for maven-mvnd." >&2
    echo "Please disable validation by removing 'distributionSha256Sum' from your maven-wrapper.properties." >&2
    exit 1
  elif command -v sha256sum >/dev/null; then
    if echo "$distributionSha256Sum  $TMP_DOWNLOAD_DIR/$distributionUrlName" | sha256sum -c >/dev/null 2>&1; then
      distributionSha256Result=true
    fi
  elif command -v shasum >/dev/null; then
    if echo "$distributionSha256Sum  $TMP_DOWNLOAD_DIR/$distributionUrlName" | shasum -a 256 -c >/dev/null 2>&1; then
      distributionSha256Result=true
    fi
  else
    echo "Checksum validation was requested but neither 'sha256sum' or 'shasum' are available." >&2
    echo "Please install either command, or disable validation by removing 'distributionSha256Sum' from your maven-wrapper.properties." >&2
    exit 1
  fi
  if [ $distributionSha256Result = false ]; then
    echo "Error: Failed to validate Maven distribution SHA-256, your Maven distribution might be compromised." >&2
    echo "If you updated your Maven version, you need to update the specified distributionSha256Sum property." >&2
    exit 1
  fi
fi

# unzip and move
if command -v unzip >/dev/null; then
  unzip ${__MVNW_QUIET_UNZIP:+"$__MVNW_QUIET_UNZIP"} "$TMP_DOWNLOAD_DIR/$distributionUrlName" -d "$TMP_DOWNLOAD_DIR" || die "failed to unzip"
else
  tar xzf${__MVNW_QUIET_TAR:+"$__MVNW_QUIET_TAR"} "$TMP_DOWNLOAD_DIR/$distributionUrlName" -C "$TMP_DOWNLOAD_DIR" || die "failed to untar"
fi
printf %s\\n "$distributionUrl" >"$TMP_DOWNLOAD_DIR/$distributionUrlNameMain/mvnw.url"
mv -- "$TMP_DOWNLOAD_DIR/$distributionUrlNameMain" "$MAVEN_HOME" || [ -d "$MAVEN_HOME" ] || die "fail to move MAVEN_HOME"

clean || :
exec_maven "$@"



================================================
FILE: mvnw.cmd
================================================
<# : batch portion
@REM ----------------------------------------------------------------------------
@REM Licensed to the Apache Software Foundation (ASF) under one
@REM or more contributor license agreements.  See the NOTICE file
@REM distributed with this work for additional information
@REM regarding copyright ownership.  The ASF licenses this file
@REM to you under the Apache License, Version 2.0 (the
@REM "License"); you may not use this file except in compliance
@REM with the License.  You may obtain a copy of the License at
@REM
@REM    http://www.apache.org/licenses/LICENSE-2.0
@REM
@REM Unless required by applicable law or agreed to in writing,
@REM software distributed under the License is distributed on an
@REM "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
@REM KIND, either express or implied.  See the License for the
@REM specific language governing permissions and limitations
@REM under the License.
@REM ----------------------------------------------------------------------------

@REM ----------------------------------------------------------------------------
@REM Apache Maven Wrapper startup batch script, version 3.3.2
@REM
@REM Optional ENV vars
@REM   MVNW_REPOURL - repo url base for downloading maven distribution
@REM   MVNW_USERNAME/MVNW_PASSWORD - user and password for downloading maven
@REM   MVNW_VERBOSE - true: enable verbose log; others: silence the output
@REM ----------------------------------------------------------------------------

@IF "%__MVNW_ARG0_NAME__%"=="" (SET __MVNW_ARG0_NAME__=%~nx0)
@SET __MVNW_CMD__=
@SET __MVNW_ERROR__=
@SET __MVNW_PSMODULEP_SAVE=%PSModulePath%
@SET PSModulePath=
@FOR /F "usebackq tokens=1* delims==" %%A IN (`powershell -noprofile "& {$scriptDir='%~dp0'; $script='%__MVNW_ARG0_NAME__%'; icm -ScriptBlock ([Scriptblock]::Create((Get-Content -Raw '%~f0'))) -NoNewScope}"`) DO @(
  IF "%%A"=="MVN_CMD" (set __MVNW_CMD__=%%B) ELSE IF "%%B"=="" (echo %%A) ELSE (echo %%A=%%B)
)
@SET PSModulePath=%__MVNW_PSMODULEP_SAVE%
@SET __MVNW_PSMODULEP_SAVE=
@SET __MVNW_ARG0_NAME__=
@SET MVNW_USERNAME=
@SET MVNW_PASSWORD=
@IF NOT "%__MVNW_CMD__%"=="" (%__MVNW_CMD__% %*)
@echo Cannot start maven from wrapper >&2 && exit /b 1
@GOTO :EOF
: end batch / begin powershell #>

$ErrorActionPreference = "Stop"
if ($env:MVNW_VERBOSE -eq "true") {
  $VerbosePreference = "Continue"
}

# calculate distributionUrl, requires .mvn/wrapper/maven-wrapper.properties
$distributionUrl = (Get-Content -Raw "$scriptDir/.mvn/wrapper/maven-wrapper.properties" | ConvertFrom-StringData).distributionUrl
if (!$distributionUrl) {
  Write-Error "cannot read distributionUrl property in $scriptDir/.mvn/wrapper/maven-wrapper.properties"
}

switch -wildcard -casesensitive ( $($distributionUrl -replace '^.*/','') ) {
  "maven-mvnd-*" {
    $USE_MVND = $true
    $distributionUrl = $distributionUrl -replace '-bin\.[^.]*$',"-windows-amd64.zip"
    $MVN_CMD = "mvnd.cmd"
    break
  }
  default {
    $USE_MVND = $false
    $MVN_CMD = $script -replace '^mvnw','mvn'
    break
  }
}

# apply MVNW_REPOURL and calculate MAVEN_HOME
# maven home pattern: ~/.m2/wrapper/dists/{apache-maven-<version>,maven-mvnd-<version>-<platform>}/<hash>
if ($env:MVNW_REPOURL) {
  $MVNW_REPO_PATTERN = if ($USE_MVND) { "/org/apache/maven/" } else { "/maven/mvnd/" }
  $distributionUrl = "$env:MVNW_REPOURL$MVNW_REPO_PATTERN$($distributionUrl -replace '^.*'+$MVNW_REPO_PATTERN,'')"
}
$distributionUrlName = $distributionUrl -replace '^.*/',''
$distributionUrlNameMain = $distributionUrlName -replace '\.[^.]*$','' -replace '-bin$',''
$MAVEN_HOME_PARENT = "$HOME/.m2/wrapper/dists/$distributionUrlNameMain"
if ($env:MAVEN_USER_HOME) {
  $MAVEN_HOME_PARENT = "$env:MAVEN_USER_HOME/wrapper/dists/$distributionUrlNameMain"
}
$MAVEN_HOME_NAME = ([System.Security.Cryptography.MD5]::Create().ComputeHash([byte[]][char[]]$distributionUrl) | ForEach-Object {$_.ToString("x2")}) -join ''
$MAVEN_HOME = "$MAVEN_HOME_PARENT/$MAVEN_HOME_NAME"

if (Test-Path -Path "$MAVEN_HOME" -PathType Container) {
  Write-Verbose "found existing MAVEN_HOME at $MAVEN_HOME"
  Write-Output "MVN_CMD=$MAVEN_HOME/bin/$MVN_CMD"
  exit $?
}

if (! $distributionUrlNameMain -or ($distributionUrlName -eq $distributionUrlNameMain)) {
  Write-Error "distributionUrl is not valid, must end with *-bin.zip, but found $distributionUrl"
}

# prepare tmp dir
$TMP_DOWNLOAD_DIR_HOLDER = New-TemporaryFile
$TMP_DOWNLOAD_DIR = New-Item -Itemtype Directory -Path "$TMP_DOWNLOAD_DIR_HOLDER.dir"
$TMP_DOWNLOAD_DIR_HOLDER.Delete() | Out-Null
trap {
  if ($TMP_DOWNLOAD_DIR.Exists) {
    try { Remove-Item $TMP_DOWNLOAD_DIR -Recurse -Force | Out-Null }
    catch { Write-Warning "Cannot remove $TMP_DOWNLOAD_DIR" }
  }
}

New-Item -Itemtype Directory -Path "$MAVEN_HOME_PARENT" -Force | Out-Null

# Download and Install Apache Maven
Write-Verbose "Couldn't find MAVEN_HOME, downloading and installing it ..."
Write-Verbose "Downloading from: $distributionUrl"
Write-Verbose "Downloading to: $TMP_DOWNLOAD_DIR/$distributionUrlName"

$webclient = New-Object System.Net.WebClient
if ($env:MVNW_USERNAME -and $env:MVNW_PASSWORD) {
  $webclient.Credentials = New-Object System.Net.NetworkCredential($env:MVNW_USERNAME, $env:MVNW_PASSWORD)
}
[Net.ServicePointManager]::SecurityProtocol = [Net.SecurityProtocolType]::Tls12
$webclient.DownloadFile($distributionUrl, "$TMP_DOWNLOAD_DIR/$distributionUrlName") | Out-Null

# If specified, validate the SHA-256 sum of the Maven distribution zip file
$distributionSha256Sum = (Get-Content -Raw "$scriptDir/.mvn/wrapper/maven-wrapper.properties" | ConvertFrom-StringData).distributionSha256Sum
if ($distributionSha256Sum) {
  if ($USE_MVND) {
    Write-Error "Checksum validation is not supported for maven-mvnd. `nPlease disable validation by removing 'distributionSha256Sum' from your maven-wrapper.properties."
  }
  Import-Module $PSHOME\Modules\Microsoft.PowerShell.Utility -Function Get-FileHash
  if ((Get-FileHash "$TMP_DOWNLOAD_DIR/$distributionUrlName" -Algorithm SHA256).Hash.ToLower() -ne $distributionSha256Sum) {
    Write-Error "Error: Failed to validate Maven distribution SHA-256, your Maven distribution might be compromised. If you updated your Maven version, you need to update the specified distributionSha256Sum property."
  }
}

# unzip and move
Expand-Archive "$TMP_DOWNLOAD_DIR/$distributionUrlName" -DestinationPath "$TMP_DOWNLOAD_DIR" | Out-Null
Rename-Item -Path "$TMP_DOWNLOAD_DIR/$distributionUrlNameMain" -NewName $MAVEN_HOME_NAME | Out-Null
try {
  Move-Item -Path "$TMP_DOWNLOAD_DIR/$MAVEN_HOME_NAME" -Destination $MAVEN_HOME_PARENT | Out-Null
} catch {
  if (! (Test-Path -Path "$MAVEN_HOME" -PathType Container)) {
    Write-Error "fail to move MAVEN_HOME"
  }
} finally {
  try { Remove-Item $TMP_DOWNLOAD_DIR -Recurse -Force | Out-Null }
  catch { Write-Warning "Cannot remove $TMP_DOWNLOAD_DIR" }
}

Write-Output "MVN_CMD=$MAVEN_HOME/bin/$MVN_CMD"



================================================
FILE: pom.xml
================================================
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.4.6</version>
        <relativePath/>
    </parent>
    <groupId>com.seyitkoc</groupId>
    <artifactId>ams</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>ams</name>
    <description>ams</description>
    <url/>
    <licenses>
        <license/>
    </licenses>
    <developers>
        <developer/>
    </developers>
    <scm>
        <connection/>
        <developerConnection/>
        <tag/>
        <url/>
    </scm>
    <properties>
        <java.version>21</java.version>
    </properties>
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-jdbc</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>com.mysql</groupId>
            <artifactId>mysql-connector-j</artifactId>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-configuration-processor</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.security</groupId>
            <artifactId>spring-security-test</artifactId>
            <scope>test</scope>
        </dependency>

        <!--JWT Token dependencies-->
        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt-api</artifactId>
            <version>0.11.5</version>
        </dependency>
        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt-impl</artifactId>
            <version>0.11.5</version>
        </dependency>
        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt-jackson</artifactId>
            <version>0.11.5</version>
        </dependency>

        <!--Validation dependencies-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>

        <!--Byte Buddy Agent for dynamic agent loading-->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <scope>test</scope>
        </dependency>

    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <configuration>
                    <annotationProcessorPaths>
                        <path>
                            <groupId>org.springframework.boot</groupId>
                            <artifactId>spring-boot-configuration-processor</artifactId>
                        </path>
                        <path>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok</artifactId>
                        </path>
                    </annotationProcessorPaths>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <excludes>
                        <exclude>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok</artifactId>
                        </exclude>
                    </excludes>
                </configuration>
            </plugin>
        </plugins>
    </build>

</project>



================================================
FILE: src/main/java/com/seyitkoc/AmsApplication.java
================================================
package com.seyitkoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.seyitkoc")
public class AmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AmsApplication.class, args);
    }

}



================================================
FILE: src/main/java/com/seyitkoc/common/config/ApplicationConfig.java
================================================
package com.seyitkoc.common.config;

import com.seyitkoc.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    @Autowired
    private AuthRepository authRepository;

    @Bean
    public UserDetailsService userDetailsService() {
        return email -> authRepository.findAuthByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Email not found!"));
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(bCryptPasswordEncoder());
        return authenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

}



================================================
FILE: src/main/java/com/seyitkoc/common/config/HttpsRedirectConfig.java
================================================
package com.seyitkoc.common.config;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HttpsRedirectConfig {
    @Bean
    public ServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory() {
            @Override
            protected void postProcessContext(Context context) {
                SecurityConstraint constraint = new SecurityConstraint();
                constraint.setUserConstraint("CONFIDENTIAL");
                SecurityCollection collection = new SecurityCollection();
                collection.addPattern("/*");
                constraint.addCollection(collection);
                context.addConstraint(constraint);
            }
        };
        factory.addAdditionalTomcatConnectors(httpToHttpsRedirectConnector());
        return factory;
    }

    private Connector httpToHttpsRedirectConnector() {
        Connector connector = new Connector(TomcatServletWebServerFactory.DEFAULT_PROTOCOL);
        connector.setScheme("http");
        connector.setPort(8080); // HTTP gelen port
        connector.setSecure(false);
        connector.setRedirectPort(8443); // HTTPS yönlendirme portu
        return connector;
    }
}



================================================
FILE: src/main/java/com/seyitkoc/common/config/SecurityConfig.java
================================================
package com.seyitkoc.common.config;

import com.seyitkoc.common.security.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class SecurityConfig {
    private final AuthenticationProvider authenticationProvider;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(cors -> cors.configure(http))
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/auth/login").permitAll()
                        .requestMatchers("/api/user/save").permitAll()
                        .anyRequest().authenticated()
                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}



================================================
FILE: src/main/java/com/seyitkoc/common/dto/ApiResponse.java
================================================
package com.seyitkoc.common.dto;

import com.seyitkoc.common.handler.ApiError;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ApiResponse<T> {
    private boolean result;
    private ApiError<?> errorMessage;
    private T data;

    public static <T> ApiResponse<T> ok(T data){
        ApiResponse<T> apiResponse = new ApiResponse<>();
        apiResponse.setResult(true);
        apiResponse.setData(data);
        apiResponse.setErrorMessage(null);
        return apiResponse;
    }

    public static <T> ApiResponse<T> error(ApiError<?> errorMessage){
        ApiResponse<T> apiResponse = new ApiResponse<>();
        apiResponse.setResult(false);
        apiResponse.setData(null);
        apiResponse.setErrorMessage(errorMessage);
        return apiResponse;
    }
}



================================================
FILE: src/main/java/com/seyitkoc/common/exception/ApplicationException.java
================================================
package com.seyitkoc.common.exception;

public class ApplicationException extends RuntimeException {
    public ApplicationException(){}

    public ApplicationException(ErrorMessage errorMessage) {
        super(errorMessage.prepareErrorMessage());
    }

}



================================================
FILE: src/main/java/com/seyitkoc/common/exception/ErrorMessage.java
================================================
package com.seyitkoc.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {
    private MessageType messageType;

    private String ofStatic;

    public String prepareErrorMessage() {
        StringBuilder builder = new StringBuilder();
        builder.append(messageType.getMessage());
        if(ofStatic!= null){
            builder.append(" : ").append(ofStatic);
        }
        return builder.toString();
    }
}



================================================
FILE: src/main/java/com/seyitkoc/common/exception/MessageType.java
================================================
package com.seyitkoc.common.exception;

import lombok.Getter;

@Getter
public enum MessageType {
    EMAIL_EXISTS("1001","Email already exists"),
    INVALID_CREDENTIALS("1002", "Invalid credentials"),
    AUTH_SAVE_FAILED("1003", "Auth save failed"),
    TOKEN_MISSING("1004", "Token is missing"),
    TOKEN_EXPIRED("1005", "Token is expired"),
    USER_NOT_FOUND("1006", "User not found"),
    INTERNAL_SERVER_ERROR("1007", "Internal server error"),
    USER_SAVE_FAILED("1008", "User save failed"),
    UNAUTHORIZED("1009", "Unauthorized access"),
    NOT_FOUND("1010", "Resource not found"),
    BAD_REQUEST("1011", "Bad request"),
    ERROR("1012", "An error occurred"),
    AUTH_CREATION_FAILED("1013", "Auth creation failed"),;
    private final String code;

    private final String message;

    MessageType(String code, String message) {
        this.code = code;
        this.message = message;
    }
}



================================================
FILE: src/main/java/com/seyitkoc/common/handler/ApiError.java
================================================
package com.seyitkoc.common.handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiError<E> {
    private Integer status;
    private Exception<E> exception;

}



================================================
FILE: src/main/java/com/seyitkoc/common/handler/Exception.java
================================================
package com.seyitkoc.common.handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Exception<E> {

    private String hostName;

    private String path;

    private LocalDateTime createTime;

    private E message;
}


================================================
FILE: src/main/java/com/seyitkoc/common/handler/GlobalExceptionHandler.java
================================================
package com.seyitkoc.common.handler;

import com.seyitkoc.common.dto.ApiResponse;
import com.seyitkoc.common.exception.ApplicationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {ApplicationException.class})
    public ResponseEntity<ApiResponse<Void>> handleApplicationException(ApplicationException exception, WebRequest request) throws UnknownHostException {
        ApiResponse<Void> rootEntity = ApiResponse.error(createApiError(exception.getMessage(),request));

        return ResponseEntity.badRequest().body(rootEntity);
    }

    public <E> ApiError<E> createApiError(E message, WebRequest request) throws UnknownHostException {
        ApiError<E> apiError = new ApiError<>();
        apiError.setStatus(HttpStatus.BAD_REQUEST.value());

        Exception<E> exception = new Exception<>();
        exception.setCreateTime(LocalDateTime.now());
        exception.setHostName(getHostName());
        exception.setPath(request.getDescription(false).substring(4));
        exception.setMessage(message);

        apiError.setException(exception);

        return apiError;
    }

    private String getHostName() throws UnknownHostException {
        try{
            return InetAddress.getLocalHost().getHostName();
        } catch (RuntimeException e) {
            System.out.println("Error while getting hostname: " + e.getMessage());
        }
        return "";
    }

}



================================================
FILE: src/main/java/com/seyitkoc/common/security/JwtAuthenticationFilter.java
================================================
package com.seyitkoc.common.security;

import io.jsonwebtoken.security.SignatureException;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtTokenService jwtTokenService;
    private final UserDetailsService userDetailsService;

    @Autowired
    public JwtAuthenticationFilter(JwtTokenService jwtTokenService, UserDetailsService userDetailsService) {
        this.jwtTokenService = jwtTokenService;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try{
            String header = request.getHeader("Authorization");
            String token;
            String email;
            if(header == null || !header.startsWith("Bearer ")){
                filterChain.doFilter(request, response);
                return;
            }
            token = header.substring("Bearer ".length()).trim();
            if(token.isEmpty()){
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write(
                        """
                        {
                          "code": "TOKEN_EMPTY",
                          "message": "Token boş olamaz!"
                        }
                        """
                );
                return;
            }
            email = jwtTokenService.findEmailFromToken(token);

            if(email != null && SecurityContextHolder.getContext().getAuthentication() == null){
                try{
                    UserDetails userDetails = userDetailsService.loadUserByUsername(email);
                    if(userDetails != null && jwtTokenService.tokenControl(token, userDetails)){
                        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                                userDetails,
                                null,
                                userDetails.getAuthorities()
                        );
                        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                    }
                }catch (SignatureException e){
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    response.getWriter().write(
                            """
                            {
                              "code": "INVALID_TOKEN_SIGNATURE",
                              "message": "Geçersiz token imzası!"
                            }
                            """
                    );
                    return;
                }

            }
            filterChain.doFilter(request, response);
        }catch (ExpiredJwtException e){
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write(
                    """
                    {
                      "code": "TOKEN_EXPIRED",
                      "message": "Token süresi dolmuş!"
                    }
                    """
            );
        }catch (SignatureException e){
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write(
                    """
                    {
                      "code": "INVALID_TOKEN_SIGNATURE",
                      "message": "Geçersiz token imzası!"
                    }
                    """
            );
        }catch (Exception e){
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write(
                    """
                    {
                      "code": "TOKEN_PROCESSING_ERROR",
                      "message": "Token işlenirken hata oluştu: %s"
                    }
                    """.formatted(e.getMessage())
            );
        }
    }
}



================================================
FILE: src/main/java/com/seyitkoc/common/security/JwtTokenService.java
================================================
package com.seyitkoc.common.security;

import com.seyitkoc.entity.Auth;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

@Service
public class JwtTokenService {
    private final Set<String> blacklistedTokens = ConcurrentHashMap.newKeySet();

    public String findEmailFromToken(String token) {
        return exportToken(token, Claims::getSubject);
    }

    public <T> T exportToken (String token, Function<Claims, T> claimsResolver) {
        final Claims claims = Jwts.parserBuilder()
                .setSigningKey(getKey()).build().parseClaimsJws(token).getBody();
        return claimsResolver.apply(claims);
    }

    public boolean tokenControl(String token, UserDetails userDetails) {
        String email = findEmailFromToken(token);
        return email.equals(userDetails.getUsername()) && new Date().before(exportToken(token, Claims::getExpiration));
    }

    public String generateToken (UserDetails userDetails) {
        final long expirationTime = 2 * 60 * 60 * 1000; // 2 hours
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", ((Auth) userDetails).getRole().name());

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public Key getKey(){
        String secretKey = "e9b3f7b877a84d6e945e3c4a1a2c8e37e1c4a0f0d4e3f9a6b2c7d8e9f0a1b2c3";
        byte[] key = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(key);
    }

    public void blacklistToken(String token) {
        blacklistedTokens.add(token);
    }
    public boolean isTokenBlacklisted(String token) {
        return blacklistedTokens.contains(token);
    }

}



================================================
FILE: src/main/java/com/seyitkoc/controller/AnnouncementController.java
================================================
package com.seyitkoc.controller;

import com.seyitkoc.service.IAnnouncementService;
import com.seyitkoc.common.dto.ApiResponse;
import com.seyitkoc.dto.announcement.DtoAnnouncement;
import com.seyitkoc.dto.announcement.DtoAnnouncementIU;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/announcements")
public class AnnouncementController {
    private final IAnnouncementService announcementService;


    public AnnouncementController(IAnnouncementService announcementService) {
        this.announcementService = announcementService;
    }

    // CRUD Operations
    @PostMapping
    public ApiResponse<DtoAnnouncement> createAnnouncement(@Valid @RequestBody DtoAnnouncementIU dtoAnnouncementIU,
                                                           @RequestHeader("Authorization") String token) {
        return ApiResponse.ok(announcementService.createAnnouncement(dtoAnnouncementIU, token));
    }

    @GetMapping("/{id}")
    public ApiResponse<DtoAnnouncement> getAnnouncementById(
            @PathVariable("id") Long announcementId,
            @RequestParam(required = false) Long apartmentId,
            @RequestParam(required = false) Long buildingId,
            @RequestHeader("Authorization") String token) {
        return ApiResponse.ok(announcementService.getAnnouncementById(announcementId, apartmentId, buildingId, token));
    }

    @PutMapping("/{id}")
    public ApiResponse<DtoAnnouncement> updateAnnouncement(
            @PathVariable("id") Long announcementId,
            @Valid @RequestBody DtoAnnouncementIU dtoAnnouncementIU,
            @RequestHeader("Authorization") String token) {
        return ApiResponse.ok(announcementService.updateAnnouncement(announcementId, dtoAnnouncementIU, token));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteAnnouncement(
            @PathVariable("id") Long announcementId,
            @RequestHeader("Authorization") String token) {
        announcementService.deleteAnnouncement(announcementId, token);
        return ApiResponse.ok(null);
    }
}



================================================
FILE: src/main/java/com/seyitkoc/controller/ApartmentAccountController.java
================================================
package com.seyitkoc.controller;

import com.seyitkoc.service.IApartmentAccountService;
import com.seyitkoc.dto.apartmentDebts.DtoApartmentDebts;
import com.seyitkoc.common.dto.ApiResponse;
import com.seyitkoc.dto.apartmentAccount.DtoApartmentAccount;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/apartmentAccounts")
public class ApartmentAccountController {
    private final IApartmentAccountService apartmentAccountService;

    public ApartmentAccountController(IApartmentAccountService apartmentAccountService) {
        this.apartmentAccountService = apartmentAccountService;
    }

    @GetMapping("{id}")
    public ApiResponse<DtoApartmentAccount> getApartmentAccountDetailsById(@RequestHeader("Authorization") String token, @PathVariable(name = "id") Long accountId) {
        return ApiResponse.ok(apartmentAccountService.getApartmentAccountDetails(token, accountId));
    }

    @GetMapping("{id}/apartmentDebts")
    public ApiResponse<Page<DtoApartmentDebts>> getApartmentDebtsByApartmentAccountId(
            @PathVariable(name = "id") Long accountId,
            @RequestParam(value = "isPaid", required = false) Boolean isPaid,
            @RequestParam(value = "isConfirmed", required = false) Boolean isConfirmed,
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
            @RequestParam(value = "sortBy", required = false, defaultValue = "id") String sortBy,
            @RequestParam(value = "sortDirection", required = false, defaultValue = "ASC") String sortDirection,
            @RequestHeader(value = "Authorization") String token
    ) {
        return ApiResponse.ok(apartmentAccountService.getApartmentDebtsByAccountIdAndFilter(
                accountId, isPaid, isConfirmed, page, pageSize, sortBy, sortDirection, token
        ));
    }
}



================================================
FILE: src/main/java/com/seyitkoc/controller/ApartmentController.java
================================================
package com.seyitkoc.controller;

import com.seyitkoc.dto.announcement.DtoAnnouncement;
import com.seyitkoc.service.IApartmentService;
import com.seyitkoc.dto.apartmentAccount.DtoApartmentAccount;
import com.seyitkoc.common.dto.ApiResponse;
import com.seyitkoc.dto.apartment.DtoApartment;
import com.seyitkoc.dto.debt.DtoDebt;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/apartments")
public class ApartmentController {
    private final IApartmentService apartmentService;

    public ApartmentController(IApartmentService apartmentService) {
        this.apartmentService = apartmentService;
    }

    @GetMapping("/{id}")
    public ApiResponse<DtoApartment> getApartmentById(@PathVariable(name = "id") Long apartmentId, @RequestHeader("Authorization") String token) {
        return ApiResponse.ok(apartmentService.getApartmentById(token, apartmentId));
    }

    // Nested Resources
    @GetMapping("{id}/account")
    public ApiResponse<DtoApartmentAccount> getAccountByApartmentId(
            @PathVariable(name = "id") Long apartmentId,
            @RequestHeader(value = "Authorization") String token
    ) {
        return ApiResponse.ok(apartmentService.getAccountByApartmentId(token, apartmentId));
    }

    @GetMapping("{id}/announcements")
    public ApiResponse<Page<DtoAnnouncement>> getAnnouncementsByApartmentId(
            @PathVariable(name = "id") Long apartmentId,
            @RequestParam(value = "text", required = false) String text,
            @RequestParam(value = "minCreatedAt", required = false) LocalDateTime minCreatedAt,
            @RequestParam(value = "maxCreatedAt", required = false) LocalDateTime maxCreatedAt,
            @RequestParam(value = "createdBy", required = false) String createdBy,
            @RequestParam(value = "isRead", required = false) Boolean isRead,
            @RequestParam(value = "page", defaultValue = "0", required = false) int page,
            @RequestParam(value = "size", defaultValue = "10", required = false) int size,
            @RequestParam(value = "sortBy", defaultValue = "createdAt", required = false) String sortBy,
            @RequestParam(value = "sortDirection", defaultValue = "desc", required = false) String sortDirection,
            @RequestHeader(value = "Authorization") String token) {
        return ApiResponse.ok(apartmentService.getAllAnnouncementsByApartmentIdAndFilter(apartmentId, text, minCreatedAt, maxCreatedAt, createdBy, isRead, page, size, sortBy, sortDirection, token));
    }

    @GetMapping("{id}/debts")
    public ApiResponse<Page<DtoDebt>> getDebtsByApartmentId(
            @PathVariable(name = "id") Long apartmentId,
            @RequestParam(value = "text", required = false) String text,
            @RequestParam(value = "minAmount", required = false) Double minAmount,
            @RequestParam(value = "maxAmount", required = false) Double maxAmount,
            @RequestParam(value = "type", required = false) String type,
            @RequestParam(value = "minCreatedAt", required = false) LocalDateTime minCreatedAt,
            @RequestParam(value = "maxCreatedAt", required = false) LocalDateTime maxCreatedAt,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "createdAt") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDirection,
            @RequestHeader(value = "Authorization") String token
    ){
        return ApiResponse.ok(apartmentService.getAllDebtsByApartmentIdAndFilter(
                apartmentId, text, type, minAmount, maxAmount, minCreatedAt, maxCreatedAt,
                page, size, sortBy, sortDirection, token
        ));
    }

    // get owner and tenant


    // Special Operations
    @PatchMapping("/{apartmentId}/setOwner")
    public ApiResponse<DtoApartment> setApartmentOwner(
            @PathVariable(name = "apartmentId") Long apartmentId,
            @RequestParam(name = "userId") Long userId,
            @RequestHeader("Authorization") String token) {
        return ApiResponse.ok(apartmentService.setApartmentOwner(token, apartmentId, userId));
    }

    @PatchMapping("/{apartmentId}/setTenant")
    public ApiResponse<DtoApartment> setApartmentTenant(
            @PathVariable(name = "apartmentId") Long apartmentId,
            @RequestParam(name = "userId") Long userId,
            @RequestHeader("Authorization") String token) {
        return ApiResponse.ok(apartmentService.setApartmentTenant(token, apartmentId, userId));
    }
}



================================================
FILE: src/main/java/com/seyitkoc/controller/ApartmentDebtsController.java
================================================
package com.seyitkoc.controller;

import com.seyitkoc.service.IApartmentDebtsService;
import com.seyitkoc.dto.apartmentDebts.DtoApartmentDebts;
import com.seyitkoc.common.dto.ApiResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/apartmentDebts")
public class ApartmentDebtsController {
    private final IApartmentDebtsService apartmentDebtService;

    public ApartmentDebtsController(IApartmentDebtsService apartmentDebtService) {
        this.apartmentDebtService = apartmentDebtService;
    }

    @GetMapping("/{id}")
    public ApiResponse<DtoApartmentDebts> getApartmentDebtByFilter(
            @PathVariable(name = "id") Long id,
            @RequestHeader(value = "Authorization") String token
    ){
        return ApiResponse.ok(apartmentDebtService.getApartmentDebtByFilter(id, token));
    }

    @PatchMapping("/pay")
    public ApiResponse<String> paidDebt(@RequestParam("apartmentDebtId") Long apartmentDebtId, @RequestHeader("Authorization") String token) {
        return ApiResponse.ok(apartmentDebtService.paidDebt(token, apartmentDebtId));
    }

    @PatchMapping("/confirm")
    public ApiResponse<String> confirmDebtPayment(@RequestParam("apartmentDebtId") Long apartmentDebtId, @RequestHeader("Authorization") String token) {
        return ApiResponse.ok(apartmentDebtService.confirmDebtPayment(apartmentDebtId, token));
    }
}



================================================
FILE: src/main/java/com/seyitkoc/controller/AuthController.java
================================================
package com.seyitkoc.controller;

import com.seyitkoc.service.IAuthService;
import com.seyitkoc.common.dto.ApiResponse;
import com.seyitkoc.dto.auth.LoginRequest;
import com.seyitkoc.dto.auth.DtoAuth;
import com.seyitkoc.dto.auth.DtoAuthEmailUpdate;
import com.seyitkoc.dto.auth.DtoAuthPasswordUpdate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/auth")
public class AuthController {
    private final IAuthService authService;

    public AuthController(IAuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ApiResponse<DtoAuth> login(@RequestBody LoginRequest loginRequest) {
        return ApiResponse.ok(authService.login(loginRequest));
    }

    @GetMapping("/getWithToken")
    public ApiResponse<DtoAuth> getAuthInfos(@RequestHeader("authorization") String token) {
        return ApiResponse.ok(authService.getAuthInfos(token));
    }

    @PutMapping("/password")
    public ApiResponse<String> updateAuth(@RequestHeader("authorization") String token, @RequestBody DtoAuthPasswordUpdate dtoAuthPasswordUpdate) {
        return ApiResponse.ok(authService.updateAuthPassword(token, dtoAuthPasswordUpdate));
    }

    @PutMapping("/email")
    public ApiResponse<String> updateAuthEmail(@RequestHeader("authorization") String token, @RequestBody DtoAuthEmailUpdate dtoAuthEmailUpdate) {
        return ApiResponse.ok(authService.updateAuthEmail(token, dtoAuthEmailUpdate));
    }

    @DeleteMapping
    public ApiResponse<String> deleteAuth(@RequestHeader("authorization") String token) {
        return ApiResponse.ok(authService.deleteAuth(token));
    }
}



================================================
FILE: src/main/java/com/seyitkoc/controller/BuildingAccountController.java
================================================
package com.seyitkoc.controller;

import com.seyitkoc.service.IBuildingAccountService;
import com.seyitkoc.dto.buildingAccount.DtoBuildingAccount;
import com.seyitkoc.dto.buildingAccount.DtoBuildingAccountIU;
import com.seyitkoc.common.dto.ApiResponse;
import com.seyitkoc.dto.transaction.DtoTransaction;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/buildingAccounts")
public class BuildingAccountController {
    private final IBuildingAccountService buildingAccountService;

    public BuildingAccountController(IBuildingAccountService buildingAccountService) {
        this.buildingAccountService = buildingAccountService;
    }

    @GetMapping("/{id}")
    public ApiResponse<DtoBuildingAccount> getBuildingAccountById(@RequestHeader("Authorization") String token, @PathVariable(name = "id") Long accountId) {
        return ApiResponse.ok(buildingAccountService.getBuildingAccountById(accountId, token));
    }

    @GetMapping("{id}/transactions")
    public ApiResponse<Page<DtoTransaction>> getTransactionsByAccountId(
            @PathVariable(name = "id") Long accountId,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String subType,
            @RequestParam(required = false) Double minAmount,
            @RequestParam(required = false) Double maxAmount,
            @RequestParam(required = false) String text,
            @RequestParam(required = false) String startDate,
            @RequestParam(required = false) String endDate,
            @RequestParam(defaultValue = "0", required = false) int page,
            @RequestParam(defaultValue = "10", required = false) int size,
            @RequestParam(defaultValue = "transactionDate", required = false) String sortBy,
            @RequestParam(defaultValue = "asc", required = false) String sortDirection,
            @RequestHeader("Authorization") String token){
        return ApiResponse.ok(buildingAccountService
                .getAllTransactionsByAccountIdAndFilter(accountId, type, subType, minAmount, maxAmount, text,
                        startDate, endDate, page, size, sortBy, sortDirection, token));
    }

    @PostMapping
    public DtoBuildingAccount createBuildingAccount(@RequestHeader("Authorization") String token, @RequestBody DtoBuildingAccountIU dtoBuildingAccountIU) {
        return buildingAccountService.createBuildingAccount(token, dtoBuildingAccountIU);
    }

    @PutMapping("/{id}")
    public DtoBuildingAccount updateBuildingAccount(
            @RequestHeader("Authorization") String token,
            @PathVariable(name = "id") Long accountId,
            @RequestBody DtoBuildingAccountIU dtoBuildingAccountIU) {
        return buildingAccountService.updateBuildingAccount(token, accountId, dtoBuildingAccountIU);
    }

}



================================================
FILE: src/main/java/com/seyitkoc/controller/BuildingController.java
================================================
package com.seyitkoc.controller;

import com.seyitkoc.dto.announcement.DtoAnnouncement;
import com.seyitkoc.dto.apartment.DtoApartment;
import com.seyitkoc.dto.apartmentAccount.DtoApartmentAccount;
import com.seyitkoc.service.IBuildingService;
import com.seyitkoc.dto.buildingAccount.DtoBuildingAccount;
import com.seyitkoc.common.dto.ApiResponse;
import com.seyitkoc.dto.building.DtoBuilding;
import com.seyitkoc.dto.building.DtoBuildingIU;
import com.seyitkoc.dto.debt.DtoDebt;
import com.seyitkoc.dto.due.DtoDue;
import com.seyitkoc.dto.poll.DtoPoll;
import com.seyitkoc.dto.transaction.DtoTransaction;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/building")
public class BuildingController {
    private final IBuildingService buildingService;

    public BuildingController(IBuildingService buildingService) {
        this.buildingService = buildingService;
    }

    // CRUD Operations
    @PostMapping
    public ApiResponse<String> saveBuilding(@Valid @RequestBody DtoBuildingIU dtoBuildingIU) {
        return ApiResponse.ok(buildingService.saveBuilding(dtoBuildingIU));
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ApiResponse<Page<DtoBuilding>> getAllBuildings(
            @RequestParam(value = "page", defaultValue = "0", required = false) int page,
            @RequestParam(value = "size", defaultValue = "10", required = false) int size,
            @RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortBy,
            @RequestParam(value = "sortDirection", defaultValue = "asc", required = false) String sortDirection) {
        return ApiResponse.ok(buildingService.getAllBuildings(page, size, sortBy, sortDirection));
    }

    @GetMapping("{id}")
    public ApiResponse<DtoBuilding> getBuildingById(@RequestHeader("authorization") String token, @PathVariable(name = "id") Long buildingId){
        return ApiResponse.ok(buildingService.getBuildingById(token, buildingId));
    }

    @PutMapping("{id}/update")
    public ApiResponse<String> updateBuilding(@RequestBody DtoBuildingIU dtoBuildingIU, @PathVariable Long id, @RequestHeader("authorization") String token) {
        return ApiResponse.ok(buildingService.updateBuilding(dtoBuildingIU, id, token));
    }

    @DeleteMapping("{id}/delete")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ApiResponse<String> deleteBuilding(@PathVariable Long id) {
        return ApiResponse.ok( buildingService.deleteBuilding(id));
    }

    // Nested Resources (Sub-resources)
    @GetMapping("{id}/apartments")
    public ApiResponse<Page<DtoApartment>> getApartmentsByBuildingId(
            @RequestHeader("authorization") String token,
            @PathVariable(name = "id") Long buildingId,
            @RequestParam(value = "page", defaultValue = "0", required = false) int page,
            @RequestParam(value = "size", defaultValue = "10", required = false) int size,
            @RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortBy,
            @RequestParam(value = "sortDirection", defaultValue = "asc", required = false) String sortDirection) {
        return ApiResponse.ok(buildingService.getAllApartmentsByBuildingId(token, buildingId, page, size, sortBy, sortDirection));
    }

    @GetMapping("{id}/apartments/accounts")
    public ApiResponse<Page<DtoApartmentAccount>> getApartmentAccountsByBuildingId(
            @PathVariable(name = "id") Long buildingId,
            @RequestParam(value = "page", defaultValue = "0", required = false) int page,
            @RequestParam(value = "size", defaultValue = "10", required = false) int size,
            @RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortBy,
            @RequestParam(value = "sortDirection", defaultValue = "asc", required = false) String sortDirection,
            @RequestHeader("authorization") String token){
        return ApiResponse.ok(buildingService
                .getAllApartmentAccountsByBuildingId(buildingId, page, size, sortBy, sortDirection, token));
    }

    @GetMapping("{id}/announcements")
    public ApiResponse<Page<DtoAnnouncement>> getAnnouncementsByBuildingId(
            @RequestHeader("authorization") String token,
            @PathVariable(name = "id") Long buildingId,
            @RequestParam(value = "text", required = false) String text,
            @RequestParam(value = "minCreatedAt", required = false) LocalDateTime minCreatedAt,
            @RequestParam(value = "maxCreatedAt", required = false) LocalDateTime maxCreatedAt,
            @RequestParam(value = "createdBy", required = false) String createdBy,
            @RequestParam(value = "page", defaultValue = "0", required = false) int page,
            @RequestParam(value = "size", defaultValue = "10", required = false) int size,
            @RequestParam(value = "sortBy", defaultValue = "createdAt", required = false) String sortBy,
            @RequestParam(value = "sortDirection", defaultValue = "desc", required = false) String sortDirection) {
        return ApiResponse.ok(buildingService.getAnnouncementsByBuildingId(token, buildingId, text, minCreatedAt, maxCreatedAt, createdBy, page, size, sortBy, sortDirection));
    }

    @GetMapping("{id}/accounts")
    public ApiResponse<Page<DtoBuildingAccount>> getBuildingAccountByBuildingId(
            @PathVariable(name = "id") Long buildingId,
            @RequestParam(value = "year", defaultValue = "0", required = false) int year,
            @RequestParam(value = "page", defaultValue = "0", required = false) int page,
            @RequestParam(value = "size", defaultValue = "10", required = false) int size,
            @RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortBy,
            @RequestParam(value = "sortDirection", defaultValue = "asc", required = false) String sortDirection,
            @RequestHeader("authorization") String token) {
        return ApiResponse.ok(buildingService.getAllBuildingAccountsByBuildingId(buildingId, year, page, size, sortBy, sortDirection, token));
    }

    @GetMapping("{id}/transactions")
    public ApiResponse<Page<DtoTransaction>> getTransactionsByBuildingIdAndFilter(
            @PathVariable(name = "id") Long id,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String subType,
            @RequestParam(required = false) Double minAmount,
            @RequestParam(required = false) Double maxAmount,
            @RequestParam(required = false) String text,
            @RequestParam(required = false) String startDate,
            @RequestParam(required = false) String endDate,
            @RequestParam(defaultValue = "0", required = false) int page,
            @RequestParam(defaultValue = "10", required = false) int size,
            @RequestParam(defaultValue = "transactionDate", required = false) String sortBy,
            @RequestParam(defaultValue = "asc", required = false) String sortDirection,
            @RequestHeader(value = "Authorization") String token
    ){
        return ApiResponse.ok(buildingService
                .getAllTransactionsByBuildingIdAndFilter(token, id, type, subType, minAmount, maxAmount, text, startDate, endDate,
                        page, size, sortBy, sortDirection));
    }

    @GetMapping("{id}/debts")
    public ApiResponse<Page<DtoDebt>> getDebtsByBuildingId(
            @PathVariable(name = "id") Long buildingId,
            @RequestParam(value = "text", required = false) String text,
            @RequestParam(value = "minAmount", required = false) Double minAmount,
            @RequestParam(value = "maxAmount", required = false) Double maxAmount,
            @RequestParam(value = "type", required = false) String type,
            @RequestParam(value = "minCreatedAt", required = false) LocalDateTime minCreatedAt,
            @RequestParam(value = "maxCreatedAt", required = false) LocalDateTime maxCreatedAt,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "createdAt") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDirection,
            @RequestHeader(value = "Authorization") String token
    ){
        return ApiResponse.ok(buildingService
                .getAllDebtsByBuildingIdAndFilter(buildingId, text, type, minAmount, maxAmount,
                        minCreatedAt, maxCreatedAt, page, size, sortBy, sortDirection, token));
    }

    @GetMapping("{id}/due")
    public ApiResponse<DtoDue> getDueByBuildingId(
            @PathVariable(name = "id") Long buildingId,
            @RequestHeader(value = "Authorization") String token
    ){
        return ApiResponse.ok(buildingService.getDueByBuildingId(buildingId, token));
    }

    @GetMapping("{id}/polls")
    public ApiResponse<Page<DtoPoll>> getAllPollsByBuildingId(
            @PathVariable(name = "id") Long buildingId,
            @RequestParam(value = "text", required = false) String text,
            @RequestParam(value = "minCreatedAt", required = false) LocalDateTime minCreatedAt,
            @RequestParam(value = "maxCreatedAt", required = false) LocalDateTime maxCreatedAt,
            @RequestParam(value = "isFinish", required = false) boolean isFinished,
            @RequestParam(value = "page", defaultValue = "0", required = false) int page,
            @RequestParam(value = "size", defaultValue = "10", required = false) int size,
            @RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortBy,
            @RequestParam(value = "sortDirection", defaultValue = "asc", required = false) String sortDirection,
            @RequestHeader("authorization") String token){
        return ApiResponse.ok(buildingService.getAllPollsByBuildingId(buildingId, text, minCreatedAt, maxCreatedAt, isFinished, page, size, sortBy, sortDirection, token));
    }

    // Special Operations
    @PatchMapping("/{id}/status")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ApiResponse<String> updateBuildingStatus(@PathVariable Long id, @RequestParam(name = "status") String status) {
        return ApiResponse.ok(buildingService.updateBuildingStatus(id, status));
    }

    @PutMapping("{id}/change-manager")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ApiResponse<DtoBuilding> changeManager(@RequestParam(value = "managerId") Long managerId, @PathVariable(name = "id") Long buildingId) {
        return ApiResponse.ok(buildingService.changeManager(buildingId, managerId));
    }
}



================================================
FILE: src/main/java/com/seyitkoc/controller/DebtController.java
================================================
package com.seyitkoc.controller;

import com.seyitkoc.dto.apartmentDebts.DtoApartmentDebts;
import com.seyitkoc.common.dto.ApiResponse;
import com.seyitkoc.service.IDebtService;
import com.seyitkoc.dto.debt.DtoDebt;
import com.seyitkoc.dto.debt.DtoDebtIU;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/debts")
public class DebtController {
    private final IDebtService debtService;

    public DebtController(IDebtService debtService) {
        this.debtService = debtService;
    }

    @PostMapping
    public ApiResponse<DtoDebt> createDebt(@Valid @RequestBody DtoDebtIU dtoDebtIU, @RequestHeader("Authorization") String token) {
        return ApiResponse.ok(debtService.createDebt(token, dtoDebtIU));
    }

    @GetMapping("/{debtId}")
    public ApiResponse<DtoDebt> getDebtById(@PathVariable Long debtId, @RequestHeader("Authorization") String token) {
        return ApiResponse.ok(debtService.getDebtById(token, debtId));
    }

    @GetMapping("{id}/apartmentDebts")
    public ApiResponse<Page<DtoApartmentDebts>> getApartmentDebtsByDebtId(
            @PathVariable(name = "id") Long id,
            @RequestParam(value = "paid", required = false) Boolean isPaid,
            @RequestParam(value = "confirm", required = false) Boolean isConfirm,
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
            @RequestParam(value = "sortBy", required = false, defaultValue = "id") String sortBy,
            @RequestParam(value = "sortDirection", required = false, defaultValue = "ASC") String sortDirection,
            @RequestHeader(value = "Authorization") String token
    ){
        return ApiResponse.ok(debtService
                .getApartmentDebtsByDebtIdAndFilter(id, isPaid, isConfirm, page, pageSize, sortBy, sortDirection, token));
    }

    @PutMapping("/{debtId}")
    public ApiResponse<DtoDebt> updateDebt(@PathVariable Long debtId, @Valid @RequestBody DtoDebtIU dtoDebtIU, @RequestHeader("Authorization") String token) {
        return ApiResponse.ok(debtService.updateDebt(token, debtId, dtoDebtIU));
    }

    @DeleteMapping("/{debtId}")
    public ApiResponse<String> deleteDebt(@PathVariable Long debtId, @RequestHeader("Authorization") String token) {
        return ApiResponse.ok(debtService.deleteDebt(token, debtId));
    }
}



================================================
FILE: src/main/java/com/seyitkoc/controller/DueController.java
================================================
package com.seyitkoc.controller;

import com.seyitkoc.common.dto.ApiResponse;
import com.seyitkoc.service.IDueService;
import com.seyitkoc.dto.due.DtoDue;
import com.seyitkoc.dto.due.DtoDueUpdate;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/dues")
public class DueController {
    private final IDueService dueService;

    public DueController(IDueService dueService) {
        this.dueService = dueService;
    }

    @GetMapping("{id}")
    public ApiResponse<DtoDue> getDueByBuildingId(@PathVariable(name = "id") Long dueId, @RequestHeader("Authorization") String token) {
        return ApiResponse.ok(dueService.getDueByBuildingId(dueId, token));
    }

    @PutMapping("{id}")
    public ApiResponse<DtoDue> updateDue(@Valid @RequestBody DtoDueUpdate dtoDueUpdate, @PathVariable(name = "id") Long dueId, @RequestHeader("Authorization") String token) {
        return ApiResponse.ok(dueService.updateDue(dtoDueUpdate, dueId, token));
    }
}



================================================
FILE: src/main/java/com/seyitkoc/controller/PollController.java
================================================
package com.seyitkoc.controller;

import com.seyitkoc.common.dto.ApiResponse;
import com.seyitkoc.service.IPollService;
import com.seyitkoc.dto.poll.DtoPollResult;
import com.seyitkoc.dto.poll.DtoPoll;
import com.seyitkoc.dto.poll.DtoPollIU;
import com.seyitkoc.dto.pollOption.DtoPollOption;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/polls")
public class PollController {
    private final IPollService pollService;

    public PollController(IPollService pollService) {
        this.pollService = pollService;
    }

    // CRUD Operations
    @PostMapping
    public ApiResponse<DtoPoll> createPoll(@Valid @RequestBody DtoPollIU dtoPollIU, @RequestHeader("Authorization") String token) {
        return ApiResponse.ok(pollService.createPoll(dtoPollIU, token));
    }

    @GetMapping("{id}")
    public ApiResponse<DtoPoll> getPollById(@PathVariable(name = "id") Long pollId, @RequestHeader("Authorization") String token) {
        return ApiResponse.ok(pollService.getPollById(pollId, token));
    }

    @PutMapping("{id}")
    public ApiResponse<String> updatePoll(@PathVariable(name = "id") Long pollId, @Valid @RequestBody DtoPollIU dtoPollIU, @RequestHeader("Authorization") String token) {
        return ApiResponse.ok(pollService.updatePoll(pollId, dtoPollIU, token));
    }

    @GetMapping("{id}/options")
    public ApiResponse<Page<DtoPollOption>> getPollOptionsByPollId(
            @PathVariable(name = "id") Long pollId,
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
            @RequestParam(value = "sortBy", required = false, defaultValue = "id") String sortBy,
            @RequestParam(value = "sortDirection", required = false, defaultValue = "ASC") String sortDirection,

            @RequestHeader(value = "Authorization") String token
    ){
        return ApiResponse.ok(pollService.getPollOptionsByPollId(pollId, page, pageSize, sortBy, sortDirection, token));
    }

    @GetMapping("{id}/results")
    public ApiResponse<DtoPollResult> getPollResults(@PathVariable(name = "id") Long pollId, @RequestHeader("Authorization") String token) {
        return ApiResponse.ok(pollService.getPollResultById(pollId, token));
    }

    // id/votes is addable here, it returns user votes by poll id.


    // Special Operations
    @PatchMapping("{id}/setActive")
    public ApiResponse<String> activatePoll(@PathVariable(name = "id") Long pollId, @RequestHeader("Authorization") String token) {
        return ApiResponse.ok(pollService.activatePoll(pollId, token));
    }

    @PatchMapping("{id}/setPassive")
    public ApiResponse<String> deactivatePoll(@PathVariable(name = "id") Long pollId, @RequestHeader("Authorization") String token) {
        return ApiResponse.ok(pollService.deactivatePoll(pollId, token));
    }
}



================================================
FILE: src/main/java/com/seyitkoc/controller/TransactionController.java
================================================
package com.seyitkoc.controller;

import com.seyitkoc.common.dto.ApiResponse;
import com.seyitkoc.service.ITransactionService;
import com.seyitkoc.dto.transaction.DtoTransaction;
import com.seyitkoc.dto.transaction.DtoTransactionIU;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {
    private final ITransactionService transactionService;

    public TransactionController(ITransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ApiResponse<DtoTransaction> createTransaction(@Valid @RequestBody DtoTransactionIU dtoTransactionIU, @RequestHeader("Authorization") String token) {
        return ApiResponse.ok(transactionService.createTransaction(dtoTransactionIU, token));
    }

    @GetMapping("/{id}")
    public ApiResponse<DtoTransaction> getTransactionById(@RequestHeader("Authorization") String token, @PathVariable Long id) {
        return ApiResponse.ok(transactionService.getTransactionById(token, id));
    }

    @PutMapping("/{id}")
    public ApiResponse<DtoTransaction> updateTransaction(
            @Valid @RequestBody DtoTransactionIU dtoTransaction,
            @RequestHeader("Authorization") String token,
            @PathVariable Long id
    ) {
        return ApiResponse.ok(transactionService.updateTransaction(dtoTransaction, token, id));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteTransaction(@RequestHeader("Authorization") String token, @PathVariable Long id) {
        transactionService.deleteTransaction(token, id);
        return ApiResponse.ok(null);
    }

}



================================================
FILE: src/main/java/com/seyitkoc/controller/UserController.java
================================================
package com.seyitkoc.controller;

import com.seyitkoc.dto.apartment.DtoApartment;
import com.seyitkoc.dto.building.DtoBuilding;
import com.seyitkoc.common.dto.ApiResponse;
import com.seyitkoc.service.IUserService;
import com.seyitkoc.dto.user.DtoUser;
import com.seyitkoc.dto.user.DtoUserCreate;
import com.seyitkoc.dto.user.DtoUserUpdate;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ApiResponse<DtoUser> getUserInfo(@RequestHeader("Authorization") String token, @RequestParam(name = "id", required = false) Long id){
        return ApiResponse.ok(userService.getUserByTokenAndId(token, id));
    }

    @PostMapping
    public ApiResponse<String> createNewUser(@Valid @RequestBody DtoUserCreate dtoUserCreate){
        return ApiResponse.ok(userService.createNewUser(dtoUserCreate));
    }

    @PutMapping
    public ApiResponse<String> updateUser(@RequestBody DtoUserUpdate dtoUserUpdate, @RequestHeader("Authorization") String token) {
        return ApiResponse.ok(userService.updateUser(token, dtoUserUpdate));
    }

    @DeleteMapping
    public ApiResponse<String> deleteUser(@RequestHeader("Authorization") String token) {
        return ApiResponse.ok(userService.deleteUser(token));
    }

    @GetMapping("/apartments/owner")
    public ApiResponse<Page<DtoApartment>> getOwnerApartmentsByUser(
            @RequestHeader(value = "Authorization") String token,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDirection){
        return ApiResponse.ok(userService.getOwnerApartmentsByUser(token, page, size, sortBy, sortDirection));
    }

    @GetMapping("/apartments/rented")
    public ApiResponse<DtoApartment> getRentedApartmentByUser(
            @RequestHeader(value = "Authorization") String token){
        return ApiResponse.ok(userService.getRentedApartmentByUser(token));
    }

    @GetMapping("/buildings")
    public ApiResponse<Page<DtoBuilding>> getBuildingsByUser(
            @RequestHeader(value = "Authorization") String token,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDirection){
        return ApiResponse.ok(userService.getBuildingsByUser(token, page, size, sortBy, sortDirection));
    }


}



================================================
FILE: src/main/java/com/seyitkoc/controller/VoteController.java
================================================
package com.seyitkoc.controller;

import com.seyitkoc.service.IVoteService;
import com.seyitkoc.entity.Vote;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/vote")
public class VoteController {
    private final IVoteService voteService;

    public VoteController(IVoteService voteService) {
        this.voteService = voteService;
    }

    @PostMapping
    public Vote vote(
            @RequestHeader("authorization") String token,
            @RequestParam(name = "pollId") Long pollId,
            @RequestParam(name = "apartmentId") Long apartmentId,
            @RequestParam(name = "optionId") Long optionId) {
        return voteService.castVote(token, pollId, apartmentId, optionId);
    }
}



================================================
FILE: src/main/java/com/seyitkoc/dto/announcement/DtoAnnouncement.java
================================================
package com.seyitkoc.dto.announcement;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class DtoAnnouncement {
    private Long id;
    private String title;
    private String content;
    private String createdBy;
    private Long buildingId;
    private String buildingName;
    private List<Long> apartmentIds;
    private List<Long> apartmentNumbers;
    private String createdAt;
    private String updatedAt;
}



================================================
FILE: src/main/java/com/seyitkoc/dto/announcement/DtoAnnouncementIU.java
================================================
package com.seyitkoc.dto.announcement;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class DtoAnnouncementIU {
    @Size(min = 1, max = 100)
    private String title;

    @Size(min = 1, max = 250)
    private String content;

    @Size(min = 1, max = 50)
    private String createdBy;

    @NotNull
    private Long buildingId;

    @NotEmpty
    private List<Long> apartmentIds; // Changed from List<Long> to Long[] for consistency with the service interface
}



================================================
FILE: src/main/java/com/seyitkoc/dto/apartment/DtoApartment.java
================================================
package com.seyitkoc.dto.apartment;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class DtoApartment {
    private Long id;
    private Long apartmentNumber;
    private Long apartmentFloor;
    private Long buildingId;
    private Long ownerId;
    private Long tenantId;
    private Long accountId;
    private String createdAt;
    private String updatedAt;
}



================================================
FILE: src/main/java/com/seyitkoc/dto/apartmentAccount/DtoApartmentAccount.java
================================================
package com.seyitkoc.dto.apartmentAccount;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class DtoApartmentAccount {
    private Long id;
    private Double balance;
    private Long apartmentId;
    private Long apartmentNumber;
}



================================================
FILE: src/main/java/com/seyitkoc/dto/apartmentDebts/DtoApartmentDebts.java
================================================
package com.seyitkoc.dto.apartmentDebts;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class DtoApartmentDebts {
    private Long id;
    private Long apartmentId;
    private Long debtId;
    private boolean isPaid;
    private String paidAt;
    private boolean isConfirmed;
    private String confirmedAt;
}



================================================
FILE: src/main/java/com/seyitkoc/dto/auth/DtoAuth.java
================================================
package com.seyitkoc.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DtoAuth {
    private String email;
    private String role;
    private Long userId;
    private String token;
}



================================================
FILE: src/main/java/com/seyitkoc/dto/auth/DtoAuthEmailUpdate.java
================================================
package com.seyitkoc.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DtoAuthEmailUpdate {
    @Email(message = "Old email format is not valid.")
    private String oldEmail;
    @Email(message = "New email format is not valid.")
    private String newEmail;
    @Size(min = 8, max = 24, message = "Password must be between 8 and 24 characters.")
    private String password;
}



================================================
FILE: src/main/java/com/seyitkoc/dto/auth/DtoAuthPasswordUpdate.java
================================================
package com.seyitkoc.dto.auth;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DtoAuthPasswordUpdate {
    @Size(min = 8, max = 24, message = "Old password must be between 8 and 24 characters.")
    private String oldPassword;
    @Size(min = 8, max = 24, message = "New password must be between 8 and 24 characters.")
    private String newPassword;
}



================================================
FILE: src/main/java/com/seyitkoc/dto/auth/LoginRequest.java
================================================
package com.seyitkoc.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LoginRequest {
    @Email(message = "Invalid email format")
    private String email;
    @Size(min = 8, max = 24, message = "Password must be between 8 and 24 characters")
    private String password;
}



================================================
FILE: src/main/java/com/seyitkoc/dto/building/DtoBuilding.java
================================================
package com.seyitkoc.dto.building;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DtoBuilding {
    private Long id;
    private String name;
    private String address;
    private Long apartmentCount;
    private Long floorCount;
    private boolean isActive;
    private Long managerId;
    private List<Long> apartmentIds;
}



================================================
FILE: src/main/java/com/seyitkoc/dto/building/DtoBuildingIU.java
================================================
package com.seyitkoc.dto.building;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DtoBuildingIU {
    @Size(min = 1, max = 50)
    private String name;

    @Size(min = 1, max = 150)
    private String address;

    @NotNull
    private Long floorCount;

    @NotNull
    private Long apartmentCount;
}



================================================
FILE: src/main/java/com/seyitkoc/dto/buildingAccount/DtoBuildingAccount.java
================================================
package com.seyitkoc.dto.buildingAccount;

import lombok.*;

import java.time.LocalDateTime;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DtoBuildingAccount {
    private Long id;
    private String name;
    private String type;
    private Integer year;
    private Double balance;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean isActive;
    private Long buildingId;
}



================================================
FILE: src/main/java/com/seyitkoc/dto/buildingAccount/DtoBuildingAccountIU.java
================================================
package com.seyitkoc.dto.buildingAccount;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DtoBuildingAccountIU {
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    @NotNull
    private String type;

    @NotNull
    private Long buildingId;

    @NotNull
    @PositiveOrZero
    private Double balance;
}



================================================
FILE: src/main/java/com/seyitkoc/dto/debt/DtoDebt.java
================================================
package com.seyitkoc.dto.debt;

import com.seyitkoc.dto.apartmentDebts.DtoApartmentDebts;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class DtoDebt {
    private Long id;
    private String description;
    private Double amount;
    private String type;
    private String createdAt;
    private String updatedAt;
    private Long buildingId;
    private List<DtoApartmentDebts> apartmentDebts;
}



================================================
FILE: src/main/java/com/seyitkoc/dto/debt/DtoDebtIU.java
================================================
package com.seyitkoc.dto.debt;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class DtoDebtIU {
    @Size(min = 1, max = 150)
    private String description;

    @NotNull
    @PositiveOrZero
    private Double amount;

    @NotNull
    private String type;

    @NotNull
    private Long buildingId;

    @NotEmpty
    private Set<Long> apartmentIds;
}



================================================
FILE: src/main/java/com/seyitkoc/dto/due/DtoDue.java
================================================
package com.seyitkoc.dto.due;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class DtoDue {
    private Long id;
    private String dayOfMonth;
    private Double dueAmount;
    private Long buildingId;
}



================================================
FILE: src/main/java/com/seyitkoc/dto/due/DtoDueUpdate.java
================================================
package com.seyitkoc.dto.due;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class DtoDueUpdate {
    private String dayOfMonth;
    private Double amount;
}



================================================
FILE: src/main/java/com/seyitkoc/dto/poll/DtoPoll.java
================================================
package com.seyitkoc.dto.poll;

import com.seyitkoc.dto.pollOption.DtoPollOption;
import com.seyitkoc.entity.Vote;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DtoPoll {
    private Long id;
    private String title;
    private String description;
    private Long buildingId;
    private String createdAt;
    private String finishedAt;
    private boolean isActive;
    private List<DtoPollOption> options;
    private List<Vote> votes;
}



================================================
FILE: src/main/java/com/seyitkoc/dto/poll/DtoPollIU.java
================================================
package com.seyitkoc.dto.poll;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DtoPollIU {
    @NotBlank(message = "Poll title cannot be blank.")
    private String title;

    @NotBlank(message = "Poll description cannot be blank.")
    private String description;

    private Long timeLimit;

    private Long buildingId;

    @NotEmpty(message = "Poll options cannot be empty.")
    private List<String> options;
}



================================================
FILE: src/main/java/com/seyitkoc/dto/poll/DtoPollResult.java
================================================
package com.seyitkoc.dto.poll;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DtoPollResult {
    DtoPoll poll;
    List<DtoPollResultItem> items;
}



================================================
FILE: src/main/java/com/seyitkoc/dto/poll/DtoPollResultItem.java
================================================
package com.seyitkoc.dto.poll;

import com.seyitkoc.dto.pollOption.DtoPollOption;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DtoPollResultItem {
    private DtoPollOption option;
    private Long count;
}



================================================
FILE: src/main/java/com/seyitkoc/dto/pollOption/DtoPollOption.java
================================================
package com.seyitkoc.dto.pollOption;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DtoPollOption {
    private Long id;
    private String optionText;
}



================================================
FILE: src/main/java/com/seyitkoc/dto/transaction/DtoTransaction.java
================================================
package com.seyitkoc.dto.transaction;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class DtoTransaction {
    private Long id;
    private String description;
    private Double amount;
    private String type; // INCOME & EXPENSE
    private String subType;
    private String transactionDate;
    private String updatedAt;
    private Long buildingAccountId;
    private String buildingAccountName;
}



================================================
FILE: src/main/java/com/seyitkoc/dto/transaction/DtoTransactionIU.java
================================================
package com.seyitkoc.dto.transaction;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class DtoTransactionIU {
    @Size(min = 1, max = 250)
    private String description;

    @NotNull
    @Positive
    private Double amount;

    @NotNull
    private String type; // INCOME & EXPENSE

    @NotNull
    private String subType;

    @NotNull
    private Long buildingAccountId;
}



================================================
FILE: src/main/java/com/seyitkoc/dto/user/DtoUser.java
================================================
package com.seyitkoc.dto.user;

import com.seyitkoc.dto.building.DtoBuilding;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DtoUser {
    private String name;
    private String phone;

    private List<DtoBuilding> buildings;
}



================================================
FILE: src/main/java/com/seyitkoc/dto/user/DtoUserCreate.java
================================================
package com.seyitkoc.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DtoUserCreate {
    @Email
    private String email;

    @Size(min = 8, max = 24)
    private String password;

    @Size(min = 1, max = 100)
    private String name;

    @Pattern(regexp = "^\\+90\\d{10}$", message = "Phone number must be in the format +90XXXXXXXXXX")
    private String phone;
}



================================================
FILE: src/main/java/com/seyitkoc/dto/user/DtoUserUpdate.java
================================================
package com.seyitkoc.dto.user;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DtoUserUpdate {
    @NotNull
    private Long id;

    @Size(min = 1, max = 100)
    private String name;

    @Pattern(regexp = "^\\+90\\d{10}$", message = "Phone number must be in the format +90XXXXXXXXXX")
    private String phone;
}



================================================
FILE: src/main/java/com/seyitkoc/entity/Announcement.java
================================================
package com.seyitkoc.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "announcements")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Announcement {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();

    @Column(name = "created_by", nullable = false)
    private String createdBy;

    @ManyToOne
    @JoinColumn(name = "building_id", nullable = false)
    @ToString.Exclude
    @JsonBackReference
    private Building building;

    @OneToMany(mappedBy = "announcement", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @ToString.Exclude
    @JsonManagedReference
    private List<ApartmentAnnouncement> apartmentAnnouncements = new ArrayList<>();

}



================================================
FILE: src/main/java/com/seyitkoc/entity/Apartment.java
================================================
package com.seyitkoc.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "apartments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Apartment {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(name = "apartment_number", nullable = false)
    private Long apartmentNumber;

    @Column(name = "apartment_floor")
    private Long apartmentFloor;

    @Column(name="created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name="updated_at", nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "building_id", nullable = false)
    @JsonBackReference
    private Building building;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    @JsonBackReference
    private User owner;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tenant_id")
    @JsonBackReference
    private User tenant;

    @OneToOne(mappedBy = "apartment", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore
    private ApartmentAccount account;

    @OneToMany(mappedBy = "apartment", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<ApartmentAnnouncement> announcements = new ArrayList<>();
}



================================================
FILE: src/main/java/com/seyitkoc/entity/ApartmentAccount.java
================================================
package com.seyitkoc.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Formula;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "apartment_account")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApartmentAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "balance", nullable = false)
    private Double balance = 0.0;

    @Column(name = "balance_updated_at", nullable = false)
    private LocalDateTime balanceUpdatedAt = LocalDateTime.now();

    @Formula("(SELECT COALESCE(SUM(d.amount), 0) FROM debts d INNER JOIN apartment_debts ad ON ad.debt_id = d.id WHERE ad.apartment_account_id = id AND ad.is_paid = false AND ad.is_confirmed = false)")
    @Basic(fetch = FetchType.LAZY)
    private Double balanceCalculated;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apartment_id", nullable = false)
    @ToString.Exclude
    @JsonBackReference
    private Apartment apartment;

    @OneToMany(mappedBy = "apartmentAccount", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonManagedReference
    @ToString.Exclude
    private List<ApartmentDebts> apartmentDebts = new ArrayList<>();
}



================================================
FILE: src/main/java/com/seyitkoc/entity/ApartmentAnnouncement.java
================================================
package com.seyitkoc.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "apartment_announcements")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ApartmentAnnouncement {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apartment_id", nullable = false)
    @JsonBackReference
    private Apartment apartment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "announcement_id", nullable = false)
    @JsonBackReference
    private Announcement announcement;

    @Column(name = "is_read", nullable = false)
    private boolean isRead = false;
}



================================================
FILE: src/main/java/com/seyitkoc/entity/ApartmentDebts.java
================================================
package com.seyitkoc.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "apartment_debts")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ApartmentDebts {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonBackReference
    private ApartmentAccount apartmentAccount;

    @ManyToOne
    @JsonBackReference
    private Debt debt;

    @Column(name = "is_paid")
    private boolean isPaid = false;
    @Column(name = "paid_at")
    private LocalDateTime paidAt;

    @Column(name = "is_confirmed")
    private boolean isConfirmed = false;
    @Column(name = "confirmed_at")
    private LocalDateTime confirmedAt;
}



================================================
FILE: src/main/java/com/seyitkoc/entity/Auth.java
================================================
package com.seyitkoc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.seyitkoc.enums.AuthRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "auths")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Auth implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="email", nullable = false, unique = true)
    private String email;

    @Column(name="password", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private AuthRole role;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false, unique = true)
    @JsonIgnore
    private User user;

    @JsonProperty("userId")
    public Long getUserId() {
        return user != null ? user.getId() : null;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

}



================================================
FILE: src/main/java/com/seyitkoc/entity/Building.java
================================================
package com.seyitkoc.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "buildings")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Building {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address", nullable = false, unique = true)
    private String address;

    @Column(name = "apartment_count", nullable = false)
    private Long apartmentCount;

    @Column(name = "floor_count", nullable = false)
    private Long floorCount;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id")
    @ToString.Exclude
    @JsonBackReference
    private User manager;

    @OneToMany(mappedBy = "building", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @ToString.Exclude
    @JsonManagedReference
    private List<Apartment> apartments;

    @OneToMany(mappedBy = "building", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @ToString.Exclude
    @JsonManagedReference
    private List<BuildingAccount> accounts;

    @OneToMany(mappedBy = "building", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @ToString.Exclude
    @JsonManagedReference
    private List<Poll> polls;

}



================================================
FILE: src/main/java/com/seyitkoc/entity/BuildingAccount.java
================================================
package com.seyitkoc.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.seyitkoc.entity.transaction.Transaction;
import com.seyitkoc.enums.AccountType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Formula;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "building_account")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class BuildingAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_name", nullable = false)
    private String accountName;

    @Column(name = "year", nullable = false)
    private Integer year;

    @Column(name = "balance", nullable = false)
    private Double balance = 0.0;

    @Column(name = "balance_updated_at", nullable = false)
    private LocalDateTime balanceUpdatedAt; // to track last balance update time

    @Formula(
            "(SELECT COALESCE(SUM(" +
                    " CASE WHEN t.type = 'INCOME' THEN t.amount " +
                    "      WHEN t.type = 'EXPENSE' THEN -t.amount " +
                    "      ELSE 0 END), 0) " +
                    " FROM transactions t WHERE t.building_account = id)"  // building_account_id yerine building_account
    )
    @Basic(fetch = FetchType.LAZY)
    private Double balanceCalculated;

    @Column(name = "account_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt; // to track last info update time (not balance update)

    @Column(name = "is_active", nullable = false)
    private boolean isActive = true;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "building_id", nullable = false)
    @JsonBackReference
    private Building building;

    @OneToMany(mappedBy = "buildingAccount", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<Transaction> transactions = new ArrayList<>();
}



================================================
FILE: src/main/java/com/seyitkoc/entity/Debt.java
================================================
package com.seyitkoc.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.seyitkoc.enums.DebtType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "debts")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Debt {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "amount")
    private Double amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private DebtType type;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();

    @OneToMany(mappedBy = "debt", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @ToString.Exclude
    @JsonManagedReference
    private List<ApartmentDebts> apartmentDebts;

    @Column(name = "building_id", nullable = false)
    private Long buildingId;
}



================================================
FILE: src/main/java/com/seyitkoc/entity/Due.java
================================================
package com.seyitkoc.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "building_due")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Due {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(name = "day_of_month")
    private String dayOfMonth;

    @Column(name = "due_amount")
    private Double dueAmount;

    @OneToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "building_id")
    private Building building;
}



================================================
FILE: src/main/java/com/seyitkoc/entity/Poll.java
================================================
package com.seyitkoc.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "polls")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Poll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "finish_date", nullable = false)
    private LocalDateTime finishDate;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "building_id", nullable = false)
    @ToString.Exclude
    @JsonBackReference
    private Building building;

    @OneToMany(mappedBy = "poll", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<PollOption> options;

    @OneToMany(mappedBy = "poll", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Vote> votes;

}



================================================
FILE: src/main/java/com/seyitkoc/entity/PollOption.java
================================================
package com.seyitkoc.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "poll_options")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PollOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "poll_id", nullable = false)
    @ToString.Exclude
    @JsonBackReference
    private Poll poll;

    @Column(name = "option_text", nullable = false)
    private String optionText;
}



================================================
FILE: src/main/java/com/seyitkoc/entity/User.java
================================================
package com.seyitkoc.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NamedEntityGraphs({
        @NamedEntityGraph(
                name = "User.ownedApartments",
                attributeNodes = @NamedAttributeNode("ownedApartments")
        ),
        @NamedEntityGraph(
                name = "User.rentedApartment",
                attributeNodes = @NamedAttributeNode("rentedApartment")
        ),
        @NamedEntityGraph(
                name = "User.managedBuildings",
                attributeNodes = @NamedAttributeNode("managedBuildings")
        )
})
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "phone", nullable = false, unique = true)
    private String phone;

    @OneToOne(mappedBy = "user")
    @JsonBackReference
    private Auth auth;

    @OneToMany(mappedBy = "manager", fetch = FetchType.LAZY)
    @ToString.Exclude
    @JsonManagedReference
    private List<Building> managedBuildings = new ArrayList<>();


    @OneToMany(mappedBy = "owner", fetch =  FetchType.LAZY)
    @ToString.Exclude
    @JsonManagedReference
    private List<Apartment> ownedApartments = new ArrayList<>();

    @OneToOne(mappedBy = "tenant", fetch = FetchType.LAZY)
    @ToString.Exclude
    @JsonManagedReference
    private Apartment rentedApartment;
}



================================================
FILE: src/main/java/com/seyitkoc/entity/Vote.java
================================================
package com.seyitkoc.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name = "votes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Vote {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "poll_id", nullable = false)
    @JsonBackReference
    private Poll poll;

    @Column(name = "voted_at", nullable = false)
    private LocalDateTime votedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "voter_id", nullable = false)
    @JsonBackReference
    private User voter; // user

    @Column(name = "voter_name", nullable = false)
    private String voterName;

    @Column(name = "voter_apartment_id", nullable = false)
    private Long voterApartmentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "poll_option_id", nullable = false)
    @JsonBackReference
    private PollOption pollOption;
}



================================================
FILE: src/main/java/com/seyitkoc/entity/transaction/Expense.java
================================================
package com.seyitkoc.entity.transaction;

import com.seyitkoc.enums.ExpenseType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@DiscriminatorValue("EXPENSE")
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@SuperBuilder
public class Expense extends Transaction {
    @Enumerated(value = EnumType.STRING)
    private ExpenseType expenseType;
}



================================================
FILE: src/main/java/com/seyitkoc/entity/transaction/Income.java
================================================
package com.seyitkoc.entity.transaction;

import com.seyitkoc.enums.IncomeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@DiscriminatorValue("INCOME")
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@SuperBuilder
public class Income extends Transaction {

    @Enumerated(value = EnumType.STRING)
    private IncomeType incomeType;
}



================================================
FILE: src/main/java/com/seyitkoc/entity/transaction/Transaction.java
================================================
package com.seyitkoc.entity.transaction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.seyitkoc.entity.BuildingAccount;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@SuperBuilder
public abstract class Transaction {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(name = "transaction_date", nullable = false)
    private LocalDateTime transactionDate;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "building_id")
    private Long buildingId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "building_account", nullable = false)
    @ToString.Exclude
    @JsonBackReference
    private BuildingAccount buildingAccount;
}



================================================
FILE: src/main/java/com/seyitkoc/enums/AccountType.java
================================================
package com.seyitkoc.enums;

public enum AccountType {
    CASH,
    BANK
}



================================================
FILE: src/main/java/com/seyitkoc/enums/AuthRole.java
================================================
package com.seyitkoc.enums;

public enum AuthRole {
    ROLE_USER,
    ROLE_ADMIN
}



================================================
FILE: src/main/java/com/seyitkoc/enums/DebtType.java
================================================
package com.seyitkoc.enums;

public enum DebtType {
    DUES,
    EXTRA,
    OTHER
}



================================================
FILE: src/main/java/com/seyitkoc/enums/ExpenseType.java
================================================
package com.seyitkoc.enums;

public enum ExpenseType {
    MAINTENANCE,
    REPAIR,
    WATER_BILL,
    ELECTRICITY_BILL,
    GAS_BILL,
    OTHER

}



================================================
FILE: src/main/java/com/seyitkoc/enums/IncomeType.java
================================================
package com.seyitkoc.enums;

public enum IncomeType {
    DUES,
    RENT,
    EXTRA,
    OTHER
}



================================================
FILE: src/main/java/com/seyitkoc/mapper/AnnouncementMapper.java
================================================
package com.seyitkoc.mapper;

import com.seyitkoc.entity.Announcement;
import com.seyitkoc.dto.announcement.DtoAnnouncement;
import com.seyitkoc.dto.announcement.DtoAnnouncementIU;
import com.seyitkoc.entity.ApartmentAnnouncement;
import com.seyitkoc.entity.Apartment;
import com.seyitkoc.entity.Building;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Component
public class AnnouncementMapper {
    public Announcement createAnnouncement(DtoAnnouncementIU dtoAnnouncementIU, Building building) {
        if(dtoAnnouncementIU == null)
            return null;

        return  Announcement.builder()
                .title(dtoAnnouncementIU.getTitle())
                .content(dtoAnnouncementIU.getContent())
                .createdBy(dtoAnnouncementIU.getCreatedBy())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .building(building)
                .build();
    }

    public DtoAnnouncement toDtoAnnouncement(Announcement announcement) {
        if (announcement == null) {
            return null;
        }
        return DtoAnnouncement.builder()
                .id(announcement.getId())
                .title(announcement.getTitle())
                .content(announcement.getContent())
                .createdBy(announcement.getCreatedBy())
                .buildingId(announcement.getBuilding().getId())
                .buildingName(announcement.getBuilding().getName())
                .apartmentIds(announcement.getApartmentAnnouncements() != null ? announcement.getApartmentAnnouncements().stream()
                        .map(ApartmentAnnouncement::getApartment)
                        .map(Apartment::getId)
                        .collect(Collectors.toList()) : null
                )
                .apartmentNumbers( announcement.getApartmentAnnouncements() != null ? announcement.getApartmentAnnouncements().stream()
                        .map(ApartmentAnnouncement::getApartment)
                        .map(Apartment::getApartmentNumber)
                        .collect(Collectors.toList()) : null
                )
                .createdAt(announcement.getCreatedAt().toString())
                .updatedAt(announcement.getUpdatedAt().toString())
                .build();

    }
}



================================================
FILE: src/main/java/com/seyitkoc/mapper/ApartmentAccountMapper.java
================================================
package com.seyitkoc.mapper;

import com.seyitkoc.entity.ApartmentAccount;
import com.seyitkoc.dto.apartmentAccount.DtoApartmentAccount;
import org.springframework.stereotype.Component;

@Component
public class ApartmentAccountMapper {

    public DtoApartmentAccount toDto(ApartmentAccount apartmentAccount) {
        if (apartmentAccount == null) {
            return null;
        }

        return DtoApartmentAccount.builder()
                .id(apartmentAccount.getId())
                .balance(apartmentAccount.getBalanceCalculated())
                .apartmentId(apartmentAccount.getApartment().getId())
                .apartmentNumber(apartmentAccount.getApartment().getApartmentNumber())
                .build();
    }
}



================================================
FILE: src/main/java/com/seyitkoc/mapper/ApartmentDebtsMapper.java
================================================
package com.seyitkoc.mapper;

import com.seyitkoc.entity.ApartmentDebts;
import com.seyitkoc.dto.apartmentDebts.DtoApartmentDebts;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApartmentDebtsMapper {
    public DtoApartmentDebts entityToDto(ApartmentDebts apartmentDebts) {
        if (apartmentDebts == null) {
            return null;
        }
        return DtoApartmentDebts.builder()
                .id(apartmentDebts.getId())
                .apartmentId(apartmentDebts.getApartmentAccount().getApartment() != null ? apartmentDebts.getApartmentAccount().getApartment().getId() : null)
                .debtId(apartmentDebts.getDebt() != null ? apartmentDebts.getDebt().getId() : null)
                .isPaid(apartmentDebts.isPaid())
                .paidAt(apartmentDebts.getPaidAt() != null ? apartmentDebts.getPaidAt().toString() : null)
                .isConfirmed(apartmentDebts.isConfirmed())
                .confirmedAt(apartmentDebts.getConfirmedAt() != null ? apartmentDebts.getConfirmedAt().toString() : null)
                .build();
    }

    public List<DtoApartmentDebts> entitiesToDtos(List<ApartmentDebts> apartmentDebtsList) {
        if (apartmentDebtsList == null || apartmentDebtsList.isEmpty()) {
            return List.of();
        }
        return apartmentDebtsList.stream()
                .map(this::entityToDto)
                .toList();
    }
}



================================================
FILE: src/main/java/com/seyitkoc/mapper/ApartmentMapper.java
================================================
package com.seyitkoc.mapper;

import com.seyitkoc.entity.Apartment;
import com.seyitkoc.dto.apartment.DtoApartment;
import org.springframework.stereotype.Component;

@Component
public class ApartmentMapper {

    public DtoApartment toDtoApartment(Apartment apartment){
        if (apartment == null)
            return null;

        return  DtoApartment.builder()
                .id(apartment.getId())
                .apartmentNumber(apartment.getApartmentNumber())
                .apartmentFloor(apartment.getApartmentFloor())
                .buildingId(apartment.getBuilding() != null ? apartment.getBuilding().getId() : null)
                .ownerId(apartment.getOwner() != null ? apartment.getOwner().getId() : null)
                .tenantId(apartment.getTenant() != null ? apartment.getTenant().getId() : null)
                .accountId(apartment.getAccount() != null ? apartment.getAccount().getId() : null)
                .createdAt(apartment.getCreatedAt().toString())
                .updatedAt(apartment.getUpdatedAt().toString())
                .build();
    }
}



================================================
FILE: src/main/java/com/seyitkoc/mapper/AuthMapper.java
================================================
package com.seyitkoc.mapper;

import com.seyitkoc.entity.Auth;
import com.seyitkoc.dto.auth.DtoAuth;
import org.springframework.stereotype.Component;

@Component
public class AuthMapper {
    public DtoAuth toDtoAuthWithToken(Auth auth, String token) {
        return new DtoAuth(auth.getEmail(), auth.getRole().name(), auth.getUser().getId(), token);
    }

    public DtoAuth toDtoAuthWithoutToken(Auth auth) {
        return new DtoAuth(auth.getEmail(), auth.getRole().name(), auth.getUser().getId(), null);
    }
}



================================================
FILE: src/main/java/com/seyitkoc/mapper/BuildingAccountMapper.java
================================================
package com.seyitkoc.mapper;

import com.seyitkoc.repository.BuildingAccountRepository;
import com.seyitkoc.entity.BuildingAccount;
import com.seyitkoc.dto.buildingAccount.DtoBuildingAccount;
import com.seyitkoc.dto.buildingAccount.DtoBuildingAccountIU;
import com.seyitkoc.entity.Building;
import com.seyitkoc.enums.AccountType;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class BuildingAccountMapper {
    private final BuildingAccountRepository buildingAccountRepository;

    public BuildingAccountMapper(BuildingAccountRepository buildingAccountRepository) {
        this.buildingAccountRepository = buildingAccountRepository;
    }

    public BuildingAccount toBuildingAccount(DtoBuildingAccountIU dtoBuildingAccountIU, Building building) {
        return BuildingAccount.builder()
                .accountName(dtoBuildingAccountIU.getName())
                .accountType(AccountType.valueOf(dtoBuildingAccountIU.getType()))
                .year(LocalDateTime.now().getYear())
                .balance(dtoBuildingAccountIU.getBalance())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .building(building)
                .isActive(true)
                .build();
    }

    public DtoBuildingAccount toDtoBuildingAccount(BuildingAccount buildingAccount) {
        buildingAccount.setBalance(buildingAccount.getBalanceCalculated());
        buildingAccount.setBalanceUpdatedAt(LocalDateTime.now());
        buildingAccountRepository.save(buildingAccount);

        return DtoBuildingAccount.builder()
                .id(buildingAccount.getId())
                .name(buildingAccount.getAccountName())
                .year(buildingAccount.getYear())
                .balance(buildingAccount.getBalance())
                .type(buildingAccount.getAccountType().name())
                .createdAt(buildingAccount.getCreatedAt())
                .updatedAt(buildingAccount.getUpdatedAt())
                .isActive(buildingAccount.isActive())
                .buildingId(buildingAccount.getBuilding().getId())
                .build();
    }
}



================================================
FILE: src/main/java/com/seyitkoc/mapper/BuildingMapper.java
================================================
package com.seyitkoc.mapper;

import com.seyitkoc.entity.Building;
import com.seyitkoc.dto.building.DtoBuilding;
import com.seyitkoc.dto.building.DtoBuildingIU;
import com.seyitkoc.entity.Apartment;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class BuildingMapper {

    public DtoBuilding toDtoBuilding(Building building) {
        DtoBuilding dtoBuilding = new DtoBuilding();
        dtoBuilding.setId(building.getId());
        dtoBuilding.setName(building.getName());
        dtoBuilding.setAddress(building.getAddress());
        dtoBuilding.setApartmentCount(building.getApartmentCount());
        dtoBuilding.setFloorCount(building.getFloorCount());
        dtoBuilding.setActive(building.isActive());
        dtoBuilding.setManagerId(building.getManager() != null ? building.getManager().getId() : null);
        dtoBuilding.setApartmentIds(building.getApartments().stream()
                .map(Apartment::getId)
                .toList());
        return dtoBuilding;
    }

    public Building toBuilding(DtoBuildingIU dtoBuildingIU) {
        Building building = new Building();
        building.setName(dtoBuildingIU.getName());
        building.setAddress(dtoBuildingIU.getAddress());
        building.setApartmentCount(dtoBuildingIU.getApartmentCount());
        building.setFloorCount(dtoBuildingIU.getFloorCount());
        building.setActive(false);
        building.setApartments(new ArrayList<>());
        return building;
    }
}



================================================
FILE: src/main/java/com/seyitkoc/mapper/DebtMapper.java
================================================
package com.seyitkoc.mapper;

import com.seyitkoc.entity.Debt;
import com.seyitkoc.dto.debt.DtoDebt;
import com.seyitkoc.dto.debt.DtoDebtIU;
import com.seyitkoc.enums.DebtType;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Component
public class DebtMapper {
    private final ApartmentDebtsMapper apartmentDebtsMapper;

    public DebtMapper(ApartmentDebtsMapper apartmentDebtsMapper) {
        this.apartmentDebtsMapper = apartmentDebtsMapper;
    }


    public Debt dtoToEntity(DtoDebtIU dtoDebtIU) {
        if (dtoDebtIU == null) {
            return null;
        }
        return Debt.builder()
                .id(null)
                .description(dtoDebtIU.getDescription())
                .amount(dtoDebtIU.getAmount())
                .type(DebtType.valueOf(dtoDebtIU.getType()))
                .buildingId(dtoDebtIU.getBuildingId())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .apartmentDebts(new ArrayList<>())
                .build();
    }

    public DtoDebt entityToDto(Debt debt) {
        if (debt == null) {
            return null;
        }
        return DtoDebt.builder()
                .id(debt.getId())
                .description(debt.getDescription())
                .amount(debt.getAmount())
                .type(debt.getType().name())
                .createdAt(debt.getCreatedAt().toString())
                .updatedAt(debt.getUpdatedAt().toString())
                .buildingId(debt.getBuildingId())
                .apartmentDebts(apartmentDebtsMapper.entitiesToDtos(debt.getApartmentDebts()))
                .build();
    }

}



================================================
FILE: src/main/java/com/seyitkoc/mapper/DueMapper.java
================================================
package com.seyitkoc.mapper;

import com.seyitkoc.entity.Due;
import com.seyitkoc.dto.due.DtoDue;
import org.springframework.stereotype.Component;

@Component
public class DueMapper {
    public DtoDue toDtoDue(Due due) {
        return DtoDue.builder()
                .id(due.getId())
                .dayOfMonth(due.getDayOfMonth())
                .dueAmount(due.getDueAmount())
                .buildingId(due.getBuilding().getId())
                .build();
    }
}



================================================
FILE: src/main/java/com/seyitkoc/mapper/PollMapper.java
================================================
package com.seyitkoc.mapper;

import com.seyitkoc.entity.Poll;
import com.seyitkoc.dto.poll.DtoPoll;
import com.seyitkoc.dto.poll.DtoPollResult;
import com.seyitkoc.dto.poll.DtoPollResultItem;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Component
public class PollMapper {
    private final PollOptionMapper pollOptionMapper;

    public PollMapper(PollOptionMapper pollOptionMapper) {
        this.pollOptionMapper = pollOptionMapper;
    }

    public DtoPoll pollToDtoPoll(Poll poll) {
        DtoPoll dtoPoll = new DtoPoll();
        dtoPoll.setId(poll.getId());
        dtoPoll.setTitle(poll.getTitle());
        dtoPoll.setDescription(poll.getDescription());
        dtoPoll.setBuildingId(poll.getBuilding().getId());
        dtoPoll.setCreatedAt(poll.getCreatedAt().toString());
        dtoPoll.setFinishedAt(poll.getFinishDate() != null ? poll.getFinishDate().toString() : null);
        dtoPoll.setActive(poll.isActive());
        dtoPoll.setOptions(poll.getOptions() != null ? poll.getOptions().stream()
                .map(pollOptionMapper::pollOptionToDtoPollOption)
                .toList() : null);
        dtoPoll.setVotes(poll.getVotes() != null ? poll.getVotes() : null);
        return dtoPoll;
    }

    public DtoPollResult pollToDtoPollResult(Poll poll) {
        DtoPollResult dtoPollResult = new DtoPollResult();
        dtoPollResult.setPoll(pollToDtoPoll(poll));
        dtoPollResult.setItems( poll.getOptions() != null ? poll.getOptions().stream().map(
                option -> {
                    DtoPollResultItem dtoPollResultItem = new DtoPollResultItem();
                    dtoPollResultItem.setOption(pollOptionMapper.pollOptionToDtoPollOption(option));
                    dtoPollResultItem.setCount(poll.getVotes().stream().filter(vote -> vote.getPollOption().equals(option)).count());
                    return dtoPollResultItem;
                }
        ).collect(Collectors.toList()) : new ArrayList<>());
        return dtoPollResult;
    }
}



================================================
FILE: src/main/java/com/seyitkoc/mapper/PollOptionMapper.java
================================================
package com.seyitkoc.mapper;

import com.seyitkoc.entity.PollOption;
import com.seyitkoc.dto.pollOption.DtoPollOption;
import org.springframework.stereotype.Component;

@Component
public class PollOptionMapper {
    public DtoPollOption pollOptionToDtoPollOption(PollOption pollOption) {
        DtoPollOption dtoPollOption = new DtoPollOption();
        dtoPollOption.setId(pollOption.getId());
        dtoPollOption.setOptionText(pollOption.getOptionText());
        return dtoPollOption;
    }
}




================================================
FILE: src/main/java/com/seyitkoc/mapper/TransactionMapper.java
================================================
package com.seyitkoc.mapper;

import com.seyitkoc.dto.transaction.DtoTransaction;
import com.seyitkoc.dto.transaction.DtoTransactionIU;
import com.seyitkoc.entity.BuildingAccount;
import com.seyitkoc.entity.transaction.Expense;
import com.seyitkoc.entity.transaction.Income;
import com.seyitkoc.entity.transaction.Transaction;
import com.seyitkoc.enums.ExpenseType;
import com.seyitkoc.enums.IncomeType;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TransactionMapper {
    public Transaction toEntity(DtoTransactionIU dtoTransactionIU, BuildingAccount buildingAccount) {
        if (dtoTransactionIU == null) {
            return null;
        }
        Transaction transaction;
        if (dtoTransactionIU.getType().equals("INCOME")) {
            transaction = Income.builder()
                    .amount(dtoTransactionIU.getAmount())
                    .description(dtoTransactionIU.getDescription())
                    .buildingAccount(buildingAccount)
                    .transactionDate(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .buildingId(buildingAccount.getBuilding().getId())
                    .incomeType(IncomeType.valueOf(dtoTransactionIU.getSubType().toUpperCase()))
                    .build();
        } else if (dtoTransactionIU.getType().equals("EXPENSE")) {
            transaction = Expense.builder()
                    .amount(dtoTransactionIU.getAmount())
                    .description(dtoTransactionIU.getDescription())
                    .buildingAccount(buildingAccount)
                    .transactionDate(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .buildingId(buildingAccount.getBuilding().getId())
                    .expenseType(ExpenseType.valueOf(dtoTransactionIU.getSubType().toUpperCase()))
                    .build();
        } else {
            throw new IllegalArgumentException("Invalid transaction type: " + dtoTransactionIU.getType());
        }
        return transaction;
    }

    public DtoTransaction toDto(Transaction transaction) {
        if (transaction == null) {
            return null;
        }
        return DtoTransaction.builder()
                .id(transaction.getId())
                .amount(transaction.getAmount())
                .description(transaction.getDescription())
                .transactionDate(transaction.getTransactionDate().toString())
                .updatedAt(transaction.getUpdatedAt() != null ? transaction.getUpdatedAt().toString() : null)
                .buildingAccountId(transaction.getBuildingAccount().getId())
                .buildingAccountName(transaction.getBuildingAccount().getAccountName())
                .type(transaction instanceof Income ? "INCOME" : "EXPENSE")
                .subType(transaction instanceof Income ? ((Income) transaction).getIncomeType().name() : ((Expense) transaction).getExpenseType().name())
                .build();
    }
}



================================================
FILE: src/main/java/com/seyitkoc/mapper/UserMapper.java
================================================
package com.seyitkoc.mapper;

import com.seyitkoc.entity.User;
import com.seyitkoc.dto.user.DtoUser;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    private final BuildingMapper buildingMapper;

    public UserMapper(BuildingMapper buildingMapper) {
        this.buildingMapper = buildingMapper;
    }

    public DtoUser toDtoUser(User user) {
        if (user == null) {
            return null;
        }

        DtoUser dtoUser = new DtoUser();
        dtoUser.setName(user.getName());
        dtoUser.setPhone(user.getPhone());
        dtoUser.setBuildings(user.getManagedBuildings().stream()
                .map(buildingMapper::toDtoBuilding)
                .toList());
        return dtoUser;
    }

}



================================================
FILE: src/main/java/com/seyitkoc/repository/AnnouncementRepository.java
================================================
package com.seyitkoc.repository;

import com.seyitkoc.entity.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AnnouncementRepository extends JpaRepository<Announcement, Long>, JpaSpecificationExecutor<Announcement> {

}



================================================
FILE: src/main/java/com/seyitkoc/repository/ApartmentAccountRepository.java
================================================
package com.seyitkoc.repository;

import com.seyitkoc.entity.ApartmentAccount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ApartmentAccountRepository extends JpaRepository<ApartmentAccount, Long> {
    Optional<ApartmentAccount> findApartmentAccountById(Long accountId);

    @Query("SELECT a FROM ApartmentAccount a WHERE a.apartment.building.id = :buildingId")
    Page<ApartmentAccount> findAllByBuildingId(Long buildingId, Pageable pageable);
}



================================================
FILE: src/main/java/com/seyitkoc/repository/ApartmentAnnouncementRepository.java
================================================
package com.seyitkoc.repository;

import com.seyitkoc.entity.ApartmentAnnouncement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApartmentAnnouncementRepository extends JpaRepository<ApartmentAnnouncement, Long> {
}



================================================
FILE: src/main/java/com/seyitkoc/repository/ApartmentDebtsRepository.java
================================================
package com.seyitkoc.repository;

import com.seyitkoc.entity.ApartmentDebts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ApartmentDebtsRepository extends JpaRepository<ApartmentDebts, Long>, JpaSpecificationExecutor<ApartmentDebts> {
}



================================================
FILE: src/main/java/com/seyitkoc/repository/ApartmentRepository.java
================================================
package com.seyitkoc.repository;

import com.seyitkoc.entity.Apartment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApartmentRepository extends JpaRepository<Apartment, Long> {
    Optional<Apartment> findApartmentById(Long apartmentId);
    Page<Apartment> findAllByBuildingId(Long buildingId, Pageable pageable);

    Page<Apartment> findAllByOwner_Id(Long ownerId, Pageable pageable);

    Apartment findApartmentByTenant_Id(Long tenantId);
}



================================================
FILE: src/main/java/com/seyitkoc/repository/AuthRepository.java
================================================
package com.seyitkoc.repository;

import com.seyitkoc.entity.Auth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AuthRepository extends JpaRepository<Auth, Long> {

    @Query("SELECT a FROM Auth a WHERE a.email = ?1")
    Optional<Auth> findAuthByEmail(String email);
}



================================================
FILE: src/main/java/com/seyitkoc/repository/BuildingAccountRepository.java
================================================
package com.seyitkoc.repository;

import com.seyitkoc.entity.BuildingAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BuildingAccountRepository extends JpaRepository<BuildingAccount, Long>, JpaSpecificationExecutor<BuildingAccount> {

}



================================================
FILE: src/main/java/com/seyitkoc/repository/BuildingRepository.java
================================================
package com.seyitkoc.repository;

import com.seyitkoc.entity.Building;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Long> {

    Page<Building> findAllByManager_Id(Long managerId, Pageable pageable);
}



================================================
FILE: src/main/java/com/seyitkoc/repository/DebtRepository.java
================================================
package com.seyitkoc.repository;

import com.seyitkoc.entity.Debt;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DebtRepository extends JpaRepository<Debt, Long>, JpaSpecificationExecutor<Debt> {
    Page<Debt> findAll(Specification<Debt> specification, Pageable pageable);
}



================================================
FILE: src/main/java/com/seyitkoc/repository/DueRepository.java
================================================
package com.seyitkoc.repository;

import com.seyitkoc.entity.Due;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DueRepository extends JpaRepository<Due, Long> {
    Optional<Due> findDueByBuildingId(Long buildingId);

    List<Due> findAllByDayOfMonth(String dayOfMonth);

   Optional<Due> findDueById(Long dueId);
}



================================================
FILE: src/main/java/com/seyitkoc/repository/PollOptionRepository.java
================================================
package com.seyitkoc.repository;

import com.seyitkoc.entity.PollOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PollOptionRepository extends JpaRepository<PollOption, Long>, JpaSpecificationExecutor<PollOption> {
}



================================================
FILE: src/main/java/com/seyitkoc/repository/PollRepository.java
================================================
package com.seyitkoc.repository;

import com.seyitkoc.entity.Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PollRepository extends JpaRepository<Poll, Long>, JpaSpecificationExecutor<Poll> {
}



================================================
FILE: src/main/java/com/seyitkoc/repository/TransactionRepository.java
================================================
package com.seyitkoc.repository;

import com.seyitkoc.entity.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>, JpaSpecificationExecutor<Transaction> {
}



================================================
FILE: src/main/java/com/seyitkoc/repository/UserRepository.java
================================================
package com.seyitkoc.repository;

import com.seyitkoc.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @EntityGraph(attributePaths = {"ownedApartments", "rentedApartment"})
    User getUserWithApartmentsById(Long id);

    @EntityGraph("managedBuildings")
    User getUserWithManagedBuildingsById(Long id);

    Optional<User> getUserById(Long id);
}



================================================
FILE: src/main/java/com/seyitkoc/repository/VoteRepository.java
================================================
package com.seyitkoc.repository;

import com.seyitkoc.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<Vote, Long> {

}


================================================
FILE: src/main/java/com/seyitkoc/service/IAnnouncementService.java
================================================
package com.seyitkoc.service;

import com.seyitkoc.dto.announcement.DtoAnnouncement;
import com.seyitkoc.dto.announcement.DtoAnnouncementIU;

import java.util.List;

public interface IAnnouncementService {
    void createAnnouncement(String title, String content, String createdBy, Long buildingId, List<Long> apartmentIds);

    // CRUD Operations
    DtoAnnouncement createAnnouncement(DtoAnnouncementIU dtoAnnouncementIU, String token);
    DtoAnnouncement getAnnouncementById(Long announcementId, Long apartmentId, Long buildingId, String token);
    DtoAnnouncement updateAnnouncement(Long announcementId, DtoAnnouncementIU dtoAnnouncementIU, String token);
    void deleteAnnouncement(Long announcementId, String token);

}



================================================
FILE: src/main/java/com/seyitkoc/service/IApartmentAccountService.java
================================================
package com.seyitkoc.service;

import com.seyitkoc.dto.apartmentAccount.DtoApartmentAccount;
import com.seyitkoc.entity.Apartment;
import com.seyitkoc.dto.apartmentDebts.DtoApartmentDebts;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IApartmentAccountService {
    void createAccounts(List<Apartment> apartment);

    DtoApartmentAccount getApartmentAccountDetails(String token, Long accountId);

    Page<DtoApartmentDebts> getApartmentDebtsByAccountIdAndFilter(Long accountId, Boolean isPaid, Boolean isConfirmed, int page, int pageSize, String sortBy, String sortDirection, String token);
}



================================================
FILE: src/main/java/com/seyitkoc/service/IApartmentAnnouncementService.java
================================================
package com.seyitkoc.service;

import com.seyitkoc.entity.Announcement;
import com.seyitkoc.entity.Apartment;

import java.util.List;

public interface IApartmentAnnouncementService {
    void createApartmentAnnouncement(Announcement announcement, Apartment apartment);

    void updateApartmentAnnouncement(Announcement announcement, List<Long> apartmentIds);

    void readApartmentAnnouncement(Announcement announcement, Long apartmentId);
}



================================================
FILE: src/main/java/com/seyitkoc/service/IApartmentDebtsService.java
================================================
package com.seyitkoc.service;

import com.seyitkoc.dto.apartmentDebts.DtoApartmentDebts;
import com.seyitkoc.entity.Building;
import com.seyitkoc.entity.Debt;

import java.util.List;

public interface IApartmentDebtsService {
    void setDebtToApartments(Debt debt, Building building, List<Long> apartmentIds);
    void updateApartmentDebts(Debt debt, Building building, List<Long> newApartmentIds);
    String paidDebt(String token, Long apartmentDebtId); // it returns apartmentDebt's dto
    String confirmDebtPayment(Long apartmentDebtId, String token); // it returns apartmentDebt's dto

    DtoApartmentDebts getApartmentDebtByFilter(Long id, String token);
}



================================================
FILE: src/main/java/com/seyitkoc/service/IApartmentService.java
================================================
package com.seyitkoc.service;

import com.seyitkoc.dto.announcement.DtoAnnouncement;
import com.seyitkoc.entity.Apartment;
import com.seyitkoc.dto.apartment.DtoApartment;
import com.seyitkoc.dto.apartmentAccount.DtoApartmentAccount;
import com.seyitkoc.entity.Building;
import com.seyitkoc.dto.debt.DtoDebt;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;

public interface IApartmentService {
    void createApartmentsForBuilding(Building building, Long apartmentCount);

    // Read Operation
    DtoApartment getApartmentById(String token, Long apartmentId);

    // Nested Resources (Sub-resources)
    DtoApartmentAccount getAccountByApartmentId(String token, Long apartmentId);
    Page<DtoAnnouncement> getAllAnnouncementsByApartmentIdAndFilter(Long apartmentId, String text, LocalDateTime minCreatedAt, LocalDateTime maxCreatedAt, String createdBy, Boolean isRead, int page, int size, String sortBy, String sortDirection, String token);
    Page<DtoDebt> getAllDebtsByApartmentIdAndFilter(Long apartmentId, String text, String type, Double minAmount, Double maxAmount, LocalDateTime minCreatedAt, LocalDateTime maxCreatedAt, int page, int size, String sortBy, String sortDirection, String token);

    // Special Operations
    DtoApartment setApartmentOwner(String token, Long apartmentId, Long userId);
    DtoApartment setApartmentTenant(String token, Long apartmentId, Long userId);



    Apartment getApartmentById(Long apartmentId);

}



================================================
FILE: src/main/java/com/seyitkoc/service/IAuthService.java
================================================
package com.seyitkoc.service;

import com.seyitkoc.entity.Auth;
import com.seyitkoc.dto.auth.LoginRequest;
import com.seyitkoc.dto.auth.DtoAuth;
import com.seyitkoc.dto.auth.DtoAuthEmailUpdate;
import com.seyitkoc.dto.auth.DtoAuthPasswordUpdate;
import com.seyitkoc.entity.User;

public interface IAuthService {
    Auth createNewAuth(String email, String password, User user);

    DtoAuth getAuthInfos(String token);

    String updateAuthPassword(String token, DtoAuthPasswordUpdate dtoAuthUpdate);

    String updateAuthEmail(String token, DtoAuthEmailUpdate dtoAuthEmailUpdate);

    String deleteAuth(String token);

    DtoAuth login(LoginRequest loginRequest);

    Auth getAuthByToken(String token);
}



================================================
FILE: src/main/java/com/seyitkoc/service/IBuildingAccountService.java
================================================
package com.seyitkoc.service;

import com.seyitkoc.entity.BuildingAccount;
import com.seyitkoc.dto.buildingAccount.DtoBuildingAccount;
import com.seyitkoc.dto.buildingAccount.DtoBuildingAccountIU;
import com.seyitkoc.entity.Building;
import com.seyitkoc.dto.transaction.DtoTransaction;
import org.springframework.data.domain.Page;

public interface IBuildingAccountService {
    void createAccountsWhenBuildingCreate(Building building);

    void updateBuildingAccountBalance(Long buildingAccountId);

    DtoBuildingAccount createBuildingAccount(String token, DtoBuildingAccountIU dtoBuildingAccountIU);

    DtoBuildingAccount getBuildingAccountById(Long id, String token);

    DtoBuildingAccount updateBuildingAccount(String token, Long accountId, DtoBuildingAccountIU dtoBuildingAccountIU);

    BuildingAccount getBuildingAccountById(Long id);

    Page<DtoTransaction> getAllTransactionsByAccountIdAndFilter(
            Long accountId, String type, String subType, Double minAmount, Double maxAmount, String text,
            String startDate, String endDate, int page, int size, String sortBy, String sortDirection, String token);
}



================================================
FILE: src/main/java/com/seyitkoc/service/IBuildingService.java
================================================
package com.seyitkoc.service;

import com.seyitkoc.dto.announcement.DtoAnnouncement;
import com.seyitkoc.dto.apartment.DtoApartment;
import com.seyitkoc.dto.apartmentAccount.DtoApartmentAccount;
import com.seyitkoc.entity.Building;
import com.seyitkoc.dto.building.DtoBuilding;
import com.seyitkoc.dto.building.DtoBuildingIU;
import com.seyitkoc.dto.buildingAccount.DtoBuildingAccount;
import com.seyitkoc.dto.debt.DtoDebt;
import com.seyitkoc.dto.due.DtoDue;
import com.seyitkoc.dto.poll.DtoPoll;
import com.seyitkoc.dto.transaction.DtoTransaction;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;

public interface IBuildingService {
    // CRUD
    String saveBuilding(DtoBuildingIU dtoBuildingIU);
    Page<DtoBuilding> getAllBuildings(int page, int size, String sortBy, String sortDirection);
    DtoBuilding getBuildingById(String token, Long buildingId);
    String updateBuilding(DtoBuildingIU dtoBuildingIU, Long id, String token);
    String deleteBuilding(Long id);

    // Nested Resources
    Page<DtoApartment> getAllApartmentsByBuildingId(
            String token, Long buildingId, int page, int size, String sortBy, String sortDirection);

    Page<DtoAnnouncement> getAnnouncementsByBuildingId(
            String token, Long buildingId, String text, LocalDateTime minCreatedAt, LocalDateTime maxCreatedAt,
            String createdBy, int page, int size, String sortBy, String sortDirection);

    Page<DtoBuildingAccount> getAllBuildingAccountsByBuildingId(
            Long buildingId, int year, int page, int size, String sortBy, String sortDirection, String token);

    Page<DtoPoll> getAllPollsByBuildingId(
            Long buildingId, String text, LocalDateTime minCreatedAt, LocalDateTime maxCreatedAt,
            boolean isFinished, int page, int size, String sortBy, String sortDirection, String token);

    Page<DtoApartmentAccount> getAllApartmentAccountsByBuildingId(
            Long buildingId, int page, int size, String sortBy, String sortDirection, String token);

    Page<DtoDebt> getAllDebtsByBuildingIdAndFilter(
            Long buildingId, String text, String type, Double minAmount, Double maxAmount, LocalDateTime minCreatedAt,
            LocalDateTime maxCreatedAt, int page, int size, String sortBy, String sortDirection, String token);

    Page<DtoTransaction> getAllTransactionsByBuildingIdAndFilter(
            String token, Long id, String type, String subType, Double minAmount, Double maxAmount, String text,
            String startDate, String endDate, int page, int size, String sortBy, String sortDirection);

    DtoDue getDueByBuildingId(Long buildingId, String token);


    // Special Operations
    String updateBuildingStatus(Long id, String status);
    DtoBuilding changeManager(Long buildingId, Long managerId);

    //
    Building getBuildingById(Long buildingId);


}



================================================
FILE: src/main/java/com/seyitkoc/service/IDebtService.java
================================================
package com.seyitkoc.service;

import com.seyitkoc.dto.apartmentDebts.DtoApartmentDebts;
import com.seyitkoc.dto.debt.DtoDebt;
import com.seyitkoc.dto.debt.DtoDebtIU;
import com.seyitkoc.entity.Due;
import org.springframework.data.domain.Page;

public interface IDebtService {
    void createDueDebt(Due due);

    DtoDebt createDebt(String token, DtoDebtIU dtoDebtIU);

    DtoDebt updateDebt(String token, Long debtId, DtoDebtIU dtoDebtIU);

    DtoDebt getDebtById(String token, Long debtId);

    String deleteDebt(String token, Long debtId);

    Page<DtoApartmentDebts> getApartmentDebtsByDebtIdAndFilter(
            Long debtId, Boolean isPaid, Boolean isConfirm, int page, int pageSize,
            String sortBy, String sortDirection, String token);
}



================================================
FILE: src/main/java/com/seyitkoc/service/IDueService.java
================================================
package com.seyitkoc.service;

import com.seyitkoc.entity.Due;
import com.seyitkoc.dto.due.DtoDue;
import com.seyitkoc.dto.due.DtoDueUpdate;
import com.seyitkoc.entity.Building;

import java.util.List;

public interface IDueService {

    List<Due> findAllByDayOfMonth ();
    void createDue(String dayOfMonth, Double amount, Building building);

    DtoDue updateDue(DtoDueUpdate dtoDueUpdate, Long dueId, String token);

    DtoDue getDueByBuildingId(Long dueId, String token);
}



================================================
FILE: src/main/java/com/seyitkoc/service/IPollOptionService.java
================================================
package com.seyitkoc.service;

import com.seyitkoc.entity.Poll;

import java.util.List;

public interface IPollOptionService {
    void createPollOption(Poll poll, List<String> options);
}



================================================
FILE: src/main/java/com/seyitkoc/service/IPollService.java
================================================
package com.seyitkoc.service;

import com.seyitkoc.dto.poll.DtoPollResult;
import com.seyitkoc.dto.poll.DtoPoll;
import com.seyitkoc.dto.poll.DtoPollIU;
import com.seyitkoc.dto.pollOption.DtoPollOption;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;

public interface IPollService {
    DtoPoll createPoll(@Valid DtoPollIU dtoPollIU, String token);
    DtoPoll getPollById(Long pollId, String token);
    String activatePoll(Long pollId, String token);
    String deactivatePoll(Long pollId, String token);
    DtoPollResult getPollResultById(Long pollId, String token);

    String updatePoll(Long pollId, @Valid DtoPollIU dtoPollIU, String token);

    Page<DtoPollOption> getPollOptionsByPollId(
            Long pollId, int page, int pageSize, String sortBy, String sortDirection, String token);
}



================================================
FILE: src/main/java/com/seyitkoc/service/ITransactionService.java
================================================
package com.seyitkoc.service;

import com.seyitkoc.dto.transaction.DtoTransaction;
import com.seyitkoc.dto.transaction.DtoTransactionIU;

public interface ITransactionService {

    DtoTransaction createTransaction(DtoTransactionIU dtoTransactionIU, String token);

    DtoTransaction getTransactionById(String token, Long id);

    DtoTransaction updateTransaction(DtoTransactionIU dtoTransaction, String token, Long id);

    void deleteTransaction(String token, Long id);
}



================================================
FILE: src/main/java/com/seyitkoc/service/IUserService.java
================================================
package com.seyitkoc.service;

import com.seyitkoc.dto.apartment.DtoApartment;
import com.seyitkoc.dto.building.DtoBuilding;
import com.seyitkoc.entity.User;
import com.seyitkoc.dto.user.DtoUser;
import com.seyitkoc.dto.user.DtoUserCreate;
import com.seyitkoc.dto.user.DtoUserUpdate;
import org.springframework.data.domain.Page;

public interface IUserService {
    String createNewUser(DtoUserCreate dtoUserCreate);

    DtoUser getUserByTokenAndId(String token, Long id);

    String updateUser(String token, DtoUserUpdate dtoUserUpdate);

    String deleteUser(String token);

    User getUserByEmail(String email);

    User getUserById(Long id);

    void checkUserIsMemberOfBuilding(String email, Long buildingId);

    void checkUserIsManagerOfBuilding(User user, Long buildingId);
    void checkUserIsManagerOfBuilding(String email, Long buildingId);

    void checkUserIsOwnerOrTenantOfApartment(User user, Long apartmentId);
    void checkUserIsOwnerOrTenantOfApartment(String email, Long apartmentId);

    void checkUserIsOwnerOfApartment(String email, Long apartmentId);

    Page<DtoBuilding> getBuildingsByUser(String token, int page, int size, String sortBy, String sortDirection);

    Page<DtoApartment> getOwnerApartmentsByUser(String token, int page, int size, String sortBy, String sortDirection);

    DtoApartment getRentedApartmentByUser(String token);
}



================================================
FILE: src/main/java/com/seyitkoc/service/IVoteService.java
================================================
package com.seyitkoc.service;

import com.seyitkoc.entity.Vote;

public interface IVoteService {
    Vote castVote(String token, Long pollId, Long apartmentId, Long voteOptionId);
}



================================================
FILE: src/main/java/com/seyitkoc/service/base/AnnouncementBaseService.java
================================================
package com.seyitkoc.service.base;

import com.seyitkoc.entity.Announcement;
import com.seyitkoc.repository.AnnouncementRepository;
import com.seyitkoc.specification.AnnouncementSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AnnouncementBaseService {
    private final AnnouncementRepository announcementRepository;
    private final AnnouncementSpecification announcementSpecification;

    public AnnouncementBaseService(AnnouncementRepository announcementRepository, AnnouncementSpecification announcementSpecification) {
        this.announcementRepository = announcementRepository;
        this.announcementSpecification = announcementSpecification;
    }

    public Page<Announcement> findAnnouncementsByBuildingIdWithFilters(
            Long buildingId, String text,
            LocalDateTime minCreatedAt, LocalDateTime maxCreatedAt, String createdBy,
            int page, int size, String sortBy, String sortDirection
    ) {
        Specification<Announcement> specification = Specification.where(announcementSpecification.byBuildingId(buildingId))
                .and(announcementSpecification.byText(text))
                .and(announcementSpecification.byMinCreatedAt(minCreatedAt))
                .and(announcementSpecification.byMaxCreatedAt(maxCreatedAt))
                .and(announcementSpecification.byCreatedBy(createdBy)); // Assuming createdBy is not used here, adjust as necessary

        return announcementRepository.findAll(specification, PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortBy)));
    }

    public Page<Announcement> findAnnouncementsByApartmentIdWithFilters(
            Long apartmentId, String text,
            LocalDateTime minCreatedAt, LocalDateTime maxCreatedAt,
            String createdBy, Boolean isRead,
            int page, int size, String sortBy, String sortDirection
    ) {
        Specification<Announcement> specification = Specification.where(announcementSpecification.byApartmentId(apartmentId))
                .and(announcementSpecification.byText(text))
                .and(announcementSpecification.byMinCreatedAt(minCreatedAt))
                .and(announcementSpecification.byMaxCreatedAt(maxCreatedAt))
                .and(announcementSpecification.byCreatedBy(createdBy))
                .and(announcementSpecification.byIsRead(isRead));

        return announcementRepository.findAll(specification, PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortBy)));
    }
}



================================================
FILE: src/main/java/com/seyitkoc/service/base/ApartmentAccountBaseService.java
================================================
package com.seyitkoc.service.base;

import com.seyitkoc.entity.ApartmentAccount;
import com.seyitkoc.repository.ApartmentAccountRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ApartmentAccountBaseService {
    private final ApartmentAccountRepository apartmentAccountRepository;

    public ApartmentAccountBaseService(ApartmentAccountRepository apartmentAccountRepository) {
        this.apartmentAccountRepository = apartmentAccountRepository;
    }

    public Page<ApartmentAccount> getAccountsByBuildingId(
            Long buildingId, int page, int pageSize, String sortBy, String sortDirection){
        Pageable pageable = PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(sortDirection), sortBy));
        return apartmentAccountRepository.findAllByBuildingId(buildingId, pageable);
    }

}



================================================
FILE: src/main/java/com/seyitkoc/service/base/ApartmentBaseService.java
================================================
package com.seyitkoc.service.base;

import com.seyitkoc.entity.Apartment;
import com.seyitkoc.repository.ApartmentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ApartmentBaseService {
    private final ApartmentRepository apartmentRepository;

    public ApartmentBaseService(ApartmentRepository apartmentRepository) {
        this.apartmentRepository = apartmentRepository;
    }

    public Page<Apartment> getAllApartmentsByBuildingId(Long buildingId, int page, int size, String sortBy, String sortDirection) {
        return apartmentRepository.findAllByBuildingId(buildingId, PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortBy)));
    }

    public Page<Apartment> getOwnerApartmentsByUserId(Long userId, int page, int size, String sortBy, String sortDirection) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortBy));
        return apartmentRepository.findAllByOwner_Id(userId, pageRequest);
    }

    public Apartment getRentedApartmentByUserId(Long id) {
        return apartmentRepository.findApartmentByTenant_Id(id);
    }
}



================================================
FILE: src/main/java/com/seyitkoc/service/base/ApartmentDebtsBaseService.java
================================================
package com.seyitkoc.service.base;

import com.seyitkoc.entity.ApartmentDebts;
import com.seyitkoc.repository.ApartmentDebtsRepository;
import com.seyitkoc.specification.ApartmentDebtsSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class ApartmentDebtsBaseService {
    private final ApartmentDebtsRepository apartmentDebtsRepository;
    private final ApartmentDebtsSpecification apartmentDebtsSpecification;

    public ApartmentDebtsBaseService(ApartmentDebtsRepository apartmentDebtsRepository, ApartmentDebtsSpecification apartmentDebtsSpecification) {
        this.apartmentDebtsRepository = apartmentDebtsRepository;
        this.apartmentDebtsSpecification = apartmentDebtsSpecification;
    }

    public Page<ApartmentDebts> getApartmentDebtsByAccountIdAndFilter(Long accountId, Boolean isPaid, Boolean isConfirmed, int page, int size, String sortBy, String sortDirection) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortBy));
        Specification<ApartmentDebts> specification = Specification.where(apartmentDebtsSpecification.byApartmentAccountId(accountId))
                .and(apartmentDebtsSpecification.byPaid(isPaid))
                .and(apartmentDebtsSpecification.byConfirmed(isConfirmed));
        return apartmentDebtsRepository.findAll(specification, pageRequest);
    }

    public Page<ApartmentDebts> getApartmentDebtsByDebtId(Long debtId, Boolean isPaid, Boolean isConfirmed, int page, int size, String sortBy, String sortDirection) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortBy));
        Specification<ApartmentDebts> specification = Specification.where(apartmentDebtsSpecification.byDebtId(debtId))
                .and(apartmentDebtsSpecification.byPaid(isPaid))
                .and(apartmentDebtsSpecification.byConfirmed(isConfirmed));

        return apartmentDebtsRepository.findAll(specification, pageRequest);
    }
}



================================================
FILE: src/main/java/com/seyitkoc/service/base/BuildingAccountBaseService.java
================================================
package com.seyitkoc.service.base;

import com.seyitkoc.entity.BuildingAccount;
import com.seyitkoc.repository.BuildingAccountRepository;
import com.seyitkoc.specification.BuildingAccountSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BuildingAccountBaseService {
    private final BuildingAccountRepository buildingAccountRepository;
    private final BuildingAccountSpecification buildingAccountSpecification;

    public BuildingAccountBaseService(BuildingAccountRepository buildingAccountRepository, BuildingAccountSpecification buildingAccountSpecification) {
        this.buildingAccountRepository = buildingAccountRepository;
        this.buildingAccountSpecification = buildingAccountSpecification;
    }

    public Page<BuildingAccount> getAllAccountsByBuildingId(Long buildingId, int year, int page, int size, String sortBy, String sortDirection) {
        Specification<BuildingAccount> specification = Specification.where(buildingAccountSpecification.byBuildingId(buildingId))
                .and(buildingAccountSpecification.byYear(year == 0 ? LocalDateTime.now().getYear() : year));

        return buildingAccountRepository.findAll(specification, PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortBy)));
    }
}



================================================
FILE: src/main/java/com/seyitkoc/service/base/BuildingBaseService.java
================================================
package com.seyitkoc.service.base;

import com.seyitkoc.entity.Building;
import com.seyitkoc.repository.BuildingRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class BuildingBaseService {
    private final BuildingRepository buildingRepository;

    public BuildingBaseService(BuildingRepository buildingRepository) {
        this.buildingRepository = buildingRepository;
    }

    public Page<Building> getBuildingsByUser(
            Long userId, int page, int pageSize, String sortBy, String sortDirection) {
        PageRequest pageRequest = PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(sortDirection), sortBy));
        return buildingRepository.findAllByManager_Id(userId, pageRequest);
    }
}



================================================
FILE: src/main/java/com/seyitkoc/service/base/DebtBaseService.java
================================================
package com.seyitkoc.service.base;

import com.seyitkoc.entity.Debt;
import com.seyitkoc.repository.DebtRepository;
import com.seyitkoc.specification.DebtSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DebtBaseService {
    private final DebtRepository debtRepository;
    private final DebtSpecification debtSpecification;

    public DebtBaseService(DebtRepository debtRepository, DebtSpecification debtSpecification) {
        this.debtRepository = debtRepository;
        this.debtSpecification = debtSpecification;
    }

    public Page<Debt> getAllDebtsByBuildingIdAndFilter(
            Long buildingId, String text, String type, Double minAmount, Double maxAmount,
            LocalDateTime minCreatedAt, LocalDateTime maxCreatedAt,
            int page, int pageSize, String sortBy, String sortDirection
    ){
        PageRequest pageRequest = PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(sortDirection), sortBy));
        Specification<Debt> specification = Specification.where(debtSpecification.hasBuildingId(buildingId))
                .and(debtSpecification.descriptionHasText(text))
                .and(debtSpecification.hasType(type))
                .and(debtSpecification.hasMinAmount(minAmount))
                .and(debtSpecification.hasMaxAmount(maxAmount))
                .and(debtSpecification.hasMinCreatedAt(minCreatedAt))
                .and(debtSpecification.hasMaxCreatedAt(maxCreatedAt));

        return  debtRepository.findAll(specification, pageRequest);
    }

    public Page<Debt> getAllDebtsByApartmentIdAndFilter(
            Long apartmentId, String text, String type, Double minAmount, Double maxAmount,
            LocalDateTime minCreatedAt, LocalDateTime maxCreatedAt,
            int page, int pageSize, String sortBy, String sortDirection
    ){
        PageRequest pageRequest = PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(sortDirection), sortBy));
        Specification<Debt> specification = Specification.where(debtSpecification.hasApartmentId(apartmentId))
                .and(debtSpecification.descriptionHasText(text))
                .and(debtSpecification.hasType(type))
                .and(debtSpecification.hasMinAmount(minAmount))
                .and(debtSpecification.hasMaxAmount(maxAmount))
                .and(debtSpecification.hasMinCreatedAt(minCreatedAt))
                .and(debtSpecification.hasMaxCreatedAt(maxCreatedAt));

        return  debtRepository.findAll(specification, pageRequest);
    }
}



================================================
FILE: src/main/java/com/seyitkoc/service/base/DueBaseService.java
================================================
package com.seyitkoc.service.base;

import com.seyitkoc.common.exception.ApplicationException;
import com.seyitkoc.common.exception.ErrorMessage;
import com.seyitkoc.common.exception.MessageType;
import com.seyitkoc.entity.Due;
import com.seyitkoc.repository.DueRepository;
import org.springframework.stereotype.Service;

@Service
public class DueBaseService {
    private final DueRepository dueRepository;

    public DueBaseService(DueRepository dueRepository) {
        this.dueRepository = dueRepository;
    }

    public Due getDueByBuildingId(Long buildingId){
        return dueRepository.findDueByBuildingId(buildingId).orElseThrow(()->
                new ApplicationException(new ErrorMessage(MessageType.NOT_FOUND,"")));
    }
}




================================================
FILE: src/main/java/com/seyitkoc/service/base/PollBaseService.java
================================================
package com.seyitkoc.service.base;

import com.seyitkoc.entity.Poll;
import com.seyitkoc.repository.PollRepository;
import com.seyitkoc.specification.PollSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PollBaseService {
    private final PollRepository pollRepository;
    private final PollSpecification pollSpecification;

    public PollBaseService(PollRepository pollRepository, PollSpecification pollSpecification) {
        this.pollRepository = pollRepository;
        this.pollSpecification = pollSpecification;
    }

    public Page<Poll> getAllPollsByBuildingIdAndFilter(
            Long buildingId,String text, LocalDateTime minCreatedAt, LocalDateTime maxCreatedAt, boolean isFinished,
            int page, int size, String sortBy, String sortDirection
    ) {
        Specification<Poll> specification = Specification.where(pollSpecification.byBuildingId(buildingId))
                .and(pollSpecification.byText(text))
                .and(pollSpecification.byMinCreateAt(minCreatedAt))
                .and(pollSpecification.byMaxCreateAt(maxCreatedAt))
                .and(pollSpecification.byIsFinished(isFinished));

        return pollRepository.findAll(specification, PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortBy)));
    }
}



================================================
FILE: src/main/java/com/seyitkoc/service/base/PollOptionBaseService.java
================================================
package com.seyitkoc.service.base;

import com.seyitkoc.entity.PollOption;
import com.seyitkoc.repository.PollOptionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class PollOptionBaseService {
    private final PollOptionRepository pollOptionRepository;

    public PollOptionBaseService(PollOptionRepository pollOptionRepository) {
        this.pollOptionRepository = pollOptionRepository;
    }

    public Page<PollOption> getPollOptionsByPollId(
            Long pollId, int page, int pageSize, String sortBy, String sortDirection){
        PageRequest pageRequest = PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(sortDirection), sortBy));
        Specification<PollOption> specification = (
                (root, query, criteriaBuilder) ->
                        criteriaBuilder.equal(root.get("poll").get("id"), pollId));
        return pollOptionRepository.findAll(specification, pageRequest);
    }

}



================================================
FILE: src/main/java/com/seyitkoc/service/base/TransactionBaseService.java
================================================
package com.seyitkoc.service.base;

import com.seyitkoc.repository.TransactionRepository;
import com.seyitkoc.specification.TransactionSpecification;
import com.seyitkoc.entity.transaction.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class TransactionBaseService {
    private final TransactionRepository transactionRepository;
    private final TransactionSpecification transactionSpecification;

    public TransactionBaseService(TransactionRepository transactionRepository, TransactionSpecification transactionSpecification) {
        this.transactionRepository = transactionRepository;
        this.transactionSpecification = transactionSpecification;
    }

    public Page<Transaction> getTransactionsByBuildingIdAndFilter(
            Long buildingId, String type, String subType, String text, Double minAmount, Double maxAmount,
            String startDate, String endDate, int page, int size, String sortBy, String sortDirection) {

        Specification<Transaction> specification = Specification.where(transactionSpecification.hasBuildingId(buildingId))
                .and(transactionSpecification.byType(type))
                .and(transactionSpecification.bySubType(type, subType))
                .and(transactionSpecification.descriptionHasText(text))
                .and(transactionSpecification.hasMinAmount(minAmount))
                .and(transactionSpecification.hasMaxAmount(maxAmount))
                .and(transactionSpecification.hasStartDate(startDate))
                .and(transactionSpecification.hasEndDate(endDate));

        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortBy));
        return transactionRepository.findAll(specification, pageRequest);
    }

    public Page<Transaction> getTransactionsByBuildingAccountIdAndFilter(
            Long accountId, String type, String subType, String text, Double minAmount, Double maxAmount,
            String startDate, String endDate, int page, int size, String sortBy, String sortDirection) {

        Specification<Transaction> specification = Specification.where(transactionSpecification.hasBuildingAccountId(accountId))
                .and(transactionSpecification.byType(type))
                .and(transactionSpecification.bySubType(type, subType))
                .and(transactionSpecification.descriptionHasText(text))
                .and(transactionSpecification.hasMinAmount(minAmount))
                .and(transactionSpecification.hasMaxAmount(maxAmount))
                .and(transactionSpecification.hasStartDate(startDate))
                .and(transactionSpecification.hasEndDate(endDate));

        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortBy));
        return transactionRepository.findAll(specification, pageRequest);
    }
}



================================================
FILE: src/main/java/com/seyitkoc/service/impl/AnnouncementServiceImpl.java
================================================
package com.seyitkoc.service.impl;

import com.seyitkoc.entity.Announcement;
import com.seyitkoc.mapper.AnnouncementMapper;
import com.seyitkoc.repository.AnnouncementRepository;
import com.seyitkoc.service.IAnnouncementService;
import com.seyitkoc.dto.announcement.DtoAnnouncement;
import com.seyitkoc.dto.announcement.DtoAnnouncementIU;
import com.seyitkoc.service.IApartmentService;
import com.seyitkoc.service.IApartmentAnnouncementService;
import com.seyitkoc.service.IBuildingService;
import com.seyitkoc.common.security.JwtTokenService;
import com.seyitkoc.service.IUserService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AnnouncementServiceImpl implements IAnnouncementService {
    private final AnnouncementMapper announcementMapper;
    private final AnnouncementRepository announcementRepository;
    private final IBuildingService buildingService;
    private final IApartmentService apartmentService;
    private final IApartmentAnnouncementService apartmentAnnouncementService;
    private final IUserService userService;
    private final JwtTokenService jwtTokenService;

    public AnnouncementServiceImpl(AnnouncementMapper announcementMapper, AnnouncementRepository announcementRepository,
                                   IBuildingService buildingService, IApartmentService apartmentService,
                                   IApartmentAnnouncementService apartmentAnnouncementService, IUserService userService,
                                   JwtTokenService jwtTokenService) {
        this.announcementMapper = announcementMapper;
        this.announcementRepository = announcementRepository;
        this.buildingService = buildingService;
        this.apartmentService = apartmentService;
        this.apartmentAnnouncementService = apartmentAnnouncementService;
        this.userService = userService;
        this.jwtTokenService = jwtTokenService;
    }

    // CRUD Operations
    @Override
    @Transactional
    public void createAnnouncement(String title, String content, String createdBy, Long buildingId, List<Long> apartmentIds) {
        DtoAnnouncementIU dtoAnnouncementIU = DtoAnnouncementIU.builder()
                .title(title)
                .content(content)
                .createdBy(createdBy)
                .buildingId(buildingId)
                .apartmentIds(new ArrayList<>())
                .build();
        Announcement announcement = announcementRepository.save(generateAnnouncement(dtoAnnouncementIU));

        apartmentIds.forEach(apartmentId -> {
            if (apartmentId != null) {
                apartmentAnnouncementService
                        .createApartmentAnnouncement(announcement, apartmentService.getApartmentById(apartmentId));
            }
        });
    }
    private Announcement generateAnnouncement(DtoAnnouncementIU dtoAnnouncementIU) {
        if (dtoAnnouncementIU == null)
            return null;

        return announcementMapper
                .createAnnouncement(dtoAnnouncementIU, buildingService.getBuildingById(dtoAnnouncementIU.getBuildingId()));
    }

    @Override
    @Transactional
    public DtoAnnouncement createAnnouncement(DtoAnnouncementIU dtoAnnouncementIU, String token) {
        userService.checkUserIsManagerOfBuilding(jwtTokenService
                .findEmailFromToken(token.replace("Bearer ", "")), dtoAnnouncementIU.getBuildingId());

        Announcement existingAnnouncement = announcementRepository.save(generateAnnouncement(dtoAnnouncementIU));
        dtoAnnouncementIU.getApartmentIds().forEach(apartmentId -> {
            if (apartmentId != null) {
                apartmentAnnouncementService
                        .createApartmentAnnouncement(existingAnnouncement, apartmentService.getApartmentById(apartmentId));
            }
        });
        return announcementMapper.toDtoAnnouncement(existingAnnouncement);
    }

    @Override
    @Transactional
    public DtoAnnouncement getAnnouncementById(Long announcementId, Long apartmentId, Long buildingId, String token) {
        Announcement announcement = announcementRepository.findById(announcementId)
                .orElseThrow(() -> new RuntimeException("Announcement not found"));

        userService.checkUserIsMemberOfBuilding(jwtTokenService
                .findEmailFromToken(token.replace("Bearer ", "")), announcement.getBuilding().getId());

        if (apartmentId != null)
            apartmentAnnouncementService.readApartmentAnnouncement(announcement, apartmentId);

        return announcementMapper.toDtoAnnouncement(announcement);
    }

    @Override
    @Transactional
    public DtoAnnouncement updateAnnouncement(Long announcementId, DtoAnnouncementIU dtoAnnouncementIU, String token) {
        Announcement announcement = announcementRepository.findById(announcementId)
                .orElseThrow(() -> new RuntimeException("Announcement not found"));
        userService.checkUserIsManagerOfBuilding(jwtTokenService
                .findEmailFromToken(token.replace("Bearer ", "")), announcement.getBuilding().getId());

        applyChanges(announcement, dtoAnnouncementIU);
        return announcementMapper.toDtoAnnouncement(announcementRepository.save(announcement));
    }
    private void applyChanges(Announcement announcement, DtoAnnouncementIU dtoAnnouncementIU) {
        if (dtoAnnouncementIU.getTitle() != null) {
            announcement.setTitle(dtoAnnouncementIU.getTitle());
        }
        if (dtoAnnouncementIU.getContent() != null) {
            announcement.setContent(dtoAnnouncementIU.getContent());
        }
        if (dtoAnnouncementIU.getCreatedBy() != null) {
            announcement.setCreatedBy(dtoAnnouncementIU.getCreatedBy());
        }
        if (dtoAnnouncementIU.getApartmentIds() != null) {
            apartmentAnnouncementService.updateApartmentAnnouncement(announcement, dtoAnnouncementIU.getApartmentIds());
        }
        announcement.setUpdatedAt(LocalDateTime.now());
    }

    @Override
    @Transactional
    public void deleteAnnouncement(Long announcementId, String token) {
        Announcement announcement = announcementRepository.findById(announcementId)
                .orElseThrow(() -> new RuntimeException("Announcement not found"));
        userService.checkUserIsManagerOfBuilding(jwtTokenService
                .findEmailFromToken(token.replace("Bearer ", "")), announcement.getBuilding().getId());

        announcementRepository.delete(announcement);
    }
}



================================================
FILE: src/main/java/com/seyitkoc/service/impl/ApartmentAccountServiceImpl.java
================================================
package com.seyitkoc.service.impl;

import com.seyitkoc.service.IApartmentAccountService;
import com.seyitkoc.entity.ApartmentAccount;
import com.seyitkoc.mapper.ApartmentAccountMapper;
import com.seyitkoc.repository.ApartmentAccountRepository;
import com.seyitkoc.dto.apartmentAccount.DtoApartmentAccount;
import com.seyitkoc.entity.Apartment;
import com.seyitkoc.service.base.ApartmentDebtsBaseService;
import com.seyitkoc.mapper.ApartmentDebtsMapper;
import com.seyitkoc.dto.apartmentDebts.DtoApartmentDebts;
import com.seyitkoc.common.exception.ApplicationException;
import com.seyitkoc.common.exception.ErrorMessage;
import com.seyitkoc.common.exception.MessageType;
import com.seyitkoc.common.security.JwtTokenService;
import com.seyitkoc.service.IUserService;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ApartmentAccountServiceImpl implements IApartmentAccountService {
    private final ApartmentAccountRepository apartmentAccountRepository;
    private final IUserService userService;
    private final JwtTokenService jwtTokenService;
    private final ApartmentAccountMapper apartmentAccountMapper;
    private final ApartmentDebtsBaseService apartmentDebtsBaseService;
    private final ApartmentDebtsMapper apartmentDebtsMapper;

    public ApartmentAccountServiceImpl(ApartmentAccountRepository apartmentAccountRepository, IUserService userService, JwtTokenService jwtTokenService, ApartmentAccountMapper apartmentAccountMapper, ApartmentDebtsBaseService apartmentDebtsBaseService, ApartmentDebtsMapper apartmentDebtsMapper) {
        this.apartmentAccountRepository = apartmentAccountRepository;
        this.userService = userService;
        this.jwtTokenService = jwtTokenService;
        this.apartmentAccountMapper = apartmentAccountMapper;
        this.apartmentDebtsBaseService = apartmentDebtsBaseService;
        this.apartmentDebtsMapper = apartmentDebtsMapper;
    }

    @Override
    @Transactional
    public void createAccounts(List<Apartment> apartments) {
        List<ApartmentAccount> apartmentAccounts = apartments.stream().map(apartment ->{
            ApartmentAccount apartmentAccount = new ApartmentAccount();
            apartmentAccount.setApartment(apartment);
            apartmentAccount.setBalance(0.0);
            return  apartmentAccount;
        }).toList();

        apartmentAccountRepository.saveAll(apartmentAccounts);
    }

    @Override
    public DtoApartmentAccount getApartmentAccountDetails(String token, Long accountId) {
        ApartmentAccount apartmentAccount = apartmentAccountRepository.findApartmentAccountById(accountId)
            .orElseThrow(() -> new RuntimeException("Apartment account not found with id: " + accountId));
        String email = jwtTokenService.findEmailFromToken(token.replace("Bearer ", ""));

        try{
            userService.checkUserIsManagerOfBuilding(email, accountId);
        }catch (ApplicationException e){
            try {
                userService.checkUserIsOwnerOrTenantOfApartment(email, accountId);
            }catch (ApplicationException ex) {
                throw new ApplicationException(new ErrorMessage(MessageType.UNAUTHORIZED, "You do not have permission to view this account."));
            }
        }
        apartmentAccount.setBalance(apartmentAccount.getBalanceCalculated());
        apartmentAccount.setBalanceUpdatedAt(LocalDateTime.now());
        apartmentAccountRepository.save(apartmentAccount);

        return apartmentAccountMapper.toDto(apartmentAccount);
    }

    @Override
    public Page<DtoApartmentDebts> getApartmentDebtsByAccountIdAndFilter(Long accountId, Boolean isPaid, Boolean isConfirmed, int page, int pageSize, String sortBy, String sortDirection, String token) {
        ApartmentAccount apartmentAccount = apartmentAccountRepository.findApartmentAccountById(accountId).orElseThrow(() ->
                new ApplicationException(new ErrorMessage(MessageType.NOT_FOUND, "Apartment account not found with id: " + accountId))
        );
        String email = jwtTokenService.findEmailFromToken(token.replace("Bearer ",""));
        try{
            userService.checkUserIsManagerOfBuilding(email, apartmentAccount.getApartment().getBuilding().getId());
        }catch (ApplicationException e){
            userService.checkUserIsOwnerOrTenantOfApartment(email, apartmentAccount.getApartment().getId());
        }

        return apartmentDebtsBaseService
                .getApartmentDebtsByAccountIdAndFilter(accountId, isPaid, isConfirmed, page, pageSize, sortBy, sortDirection)
                .map(apartmentDebtsMapper::entityToDto);
    }

}



================================================
FILE: src/main/java/com/seyitkoc/service/impl/ApartmentAnnouncementServiceImpl.java
================================================
package com.seyitkoc.service.impl;

import com.seyitkoc.service.IApartmentAnnouncementService;
import com.seyitkoc.entity.Announcement;
import com.seyitkoc.entity.Apartment;
import com.seyitkoc.service.IApartmentService;
import com.seyitkoc.entity.ApartmentAnnouncement;
import com.seyitkoc.repository.ApartmentAnnouncementRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ApartmentAnnouncementServiceImpl implements IApartmentAnnouncementService {
    private final ApartmentAnnouncementRepository apartmentAnnouncementRepository;
    private final IApartmentService apartmentService;

    public ApartmentAnnouncementServiceImpl(ApartmentAnnouncementRepository apartmentAnnouncementRepository, IApartmentService apartmentService) {
        this.apartmentAnnouncementRepository = apartmentAnnouncementRepository;
        this.apartmentService = apartmentService;
    }

    @Override
    @Transactional
    public void createApartmentAnnouncement(Announcement announcement, Apartment apartment) {
        if (announcement == null)
            throw new IllegalArgumentException("Announcement cannot be null");
        if (apartment == null)
            throw new IllegalArgumentException("Apartment cannot be null");

        ApartmentAnnouncement apartmentAnnouncement = ApartmentAnnouncement.builder()
                .announcement(announcement)
                .apartment(apartment)
                .isRead(false)
                .build();

        apartmentAnnouncementRepository.save(apartmentAnnouncement);
    }

    @Override
    @Transactional
    public void updateApartmentAnnouncement(Announcement announcement, List<Long> apartmentIds) {
        announcement.getApartmentAnnouncements().removeIf(apartmentAnnouncement ->
                !apartmentIds.contains(apartmentAnnouncement.getId())
        );

        Set<Long> existingApartmentIds = announcement.getApartmentAnnouncements().stream()
                .map(apartmentAnnouncement -> apartmentAnnouncement.getApartment().getId())
                .collect(Collectors.toSet());

        List<ApartmentAnnouncement> newApartmentAnnouncements = apartmentIds.stream()
                .filter(apartmentId -> !existingApartmentIds.contains(apartmentId))
                .map(apartmentId -> {
                    Apartment matchingApartment = apartmentService.getApartmentById(apartmentId);
                    return ApartmentAnnouncement.builder()
                            .announcement(announcement)
                            .apartment(matchingApartment)
                            .isRead(false)
                            .build();
                })
                .toList();
        announcement.getApartmentAnnouncements().addAll(newApartmentAnnouncements);
        apartmentAnnouncementRepository.saveAll(announcement.getApartmentAnnouncements());
    }

    @Override
    @Transactional
    public void readApartmentAnnouncement(Announcement announcement, Long apartmentId) {
        ApartmentAnnouncement apartmentAnnouncement = announcement.getApartmentAnnouncements().stream()
                .filter(aa -> aa.getApartment().getId().equals(apartmentId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("ApartmentAnnouncement not found for apartmentId: " + apartmentId));
        if (!apartmentAnnouncement.isRead()) {
            apartmentAnnouncement.setRead(true);
            apartmentAnnouncementRepository.save(apartmentAnnouncement);
        }
    }
}



================================================
FILE: src/main/java/com/seyitkoc/service/impl/ApartmentDebtsServiceImpl.java
================================================
package com.seyitkoc.service.impl;

import com.seyitkoc.service.IApartmentDebtsService;
import com.seyitkoc.entity.Apartment;
import com.seyitkoc.entity.ApartmentDebts;
import com.seyitkoc.mapper.ApartmentDebtsMapper;
import com.seyitkoc.repository.ApartmentDebtsRepository;
import com.seyitkoc.dto.apartmentDebts.DtoApartmentDebts;
import com.seyitkoc.entity.Building;
import com.seyitkoc.entity.Debt;
import com.seyitkoc.common.exception.ApplicationException;
import com.seyitkoc.common.exception.ErrorMessage;
import com.seyitkoc.common.exception.MessageType;
import com.seyitkoc.common.security.JwtTokenService;
import com.seyitkoc.service.IUserService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ApartmentDebtsServiceImpl implements IApartmentDebtsService {
    private final ApartmentDebtsRepository apartmentDebtRepository;
    private final JwtTokenService jwtTokenService;
    private final IUserService userService;
    private final ApartmentDebtsMapper apartmentDebtsMapper;

    public ApartmentDebtsServiceImpl(ApartmentDebtsRepository apartmentDebtRepository, JwtTokenService jwtTokenService, IUserService userService, ApartmentDebtsMapper apartmentDebtsMapper) {
        this.apartmentDebtRepository = apartmentDebtRepository;
        this.jwtTokenService = jwtTokenService;
        this.userService = userService;
        this.apartmentDebtsMapper = apartmentDebtsMapper;
    }


    @Override
    @Transactional
    public void setDebtToApartments(Debt debt, Building building, List<Long> apartmentIds) {
        List<ApartmentDebts> apartmentDebtsList = apartmentIds.stream()
                .map(apartmentId -> ApartmentDebts.builder()
                        .apartmentAccount(building.getApartments().stream()
                                .filter(apartment -> apartment.getId().equals(apartmentId))
                                .findFirst().orElseThrow(() -> new RuntimeException("Apartment not found: id=" + apartmentId)).getAccount()
                        )
                        .debt(debt)
                        .paidAt(null)
                        .confirmedAt(null)
                        .build()
                ).toList();
        apartmentDebtRepository.saveAll(apartmentDebtsList);
    }

    @Override
    @Transactional
    public void updateApartmentDebts(Debt debt, Building building, List<Long> newApartmentIds) {
        // remove ApartmentDebts that are not in the new list
        debt.getApartmentDebts().removeIf(apartmentDebt ->
                !newApartmentIds.contains(apartmentDebt.getApartmentAccount().getApartment().getId())
        );

        // find existing ApartmentDebts for the new apartment IDs
        Set<Long> existingApartmentIds = debt.getApartmentDebts().stream()
                .map(ad -> ad.getApartmentAccount().getApartment().getId())
                .collect(Collectors.toSet());

        List<ApartmentDebts> newApartmentDebts = newApartmentIds.stream()
                .filter(id -> !existingApartmentIds.contains(id))
                .map(id -> {
                    Apartment matchingApartment = building.getApartments().stream()
                            .filter(apartment -> apartment.getId().equals(id))
                            .findFirst()
                            .orElseThrow(() -> new RuntimeException("Apartment not found: id=" + id));

                    return ApartmentDebts.builder()
                            .apartmentAccount(matchingApartment.getAccount())
                            .debt(debt)
                            .paidAt(null)
                            .confirmedAt(null)
                            .build();
                })
                .toList();

        debt.getApartmentDebts().addAll(newApartmentDebts);
        apartmentDebtRepository.saveAll(debt.getApartmentDebts());
    }


    @Override
    @Transactional
    public String paidDebt(String token, Long apartmentDebtId) {
        ApartmentDebts apartmentDebt = apartmentDebtRepository.findById(apartmentDebtId)
                .orElseThrow(() -> new ApplicationException(new ErrorMessage(MessageType.NOT_FOUND, "Apartment debt not found.")));

        userService.checkUserIsOwnerOrTenantOfApartment(jwtTokenService.findEmailFromToken(token.replace("Bearer ", "")),
                apartmentDebt.getApartmentAccount().getApartment().getId());

        if (apartmentDebt.isPaid()) {
            throw new ApplicationException(new ErrorMessage(MessageType.BAD_REQUEST, "This debt is already paid."));
        }
        apartmentDebt.setPaidAt(LocalDateTime.now());
        apartmentDebt.setPaid(true);
        ApartmentDebts savedApartmentDebt = apartmentDebtRepository.save(apartmentDebt);
        return savedApartmentDebt.isPaid() ? "Debt paid successfully." : "Debt payment failed.";
    }

    @Override
    @Transactional
    public String confirmDebtPayment(Long apartmentDebtId, String token) {
        ApartmentDebts apartmentDebt = apartmentDebtRepository.findById(apartmentDebtId)
                .orElseThrow(() -> new ApplicationException(new ErrorMessage(MessageType.NOT_FOUND, "Apartment debt not found.")));
        userService.checkUserIsManagerOfBuilding(jwtTokenService.findEmailFromToken(token.replace("Bearer ", "")),
                apartmentDebt.getApartmentAccount().getApartment().getBuilding().getId());

        if (apartmentDebt.isConfirmed()) {
            throw new ApplicationException(new ErrorMessage(MessageType.BAD_REQUEST, "This debt payment is already confirmed."));
        }
        apartmentDebt.setConfirmedAt(LocalDateTime.now());
        apartmentDebt.setConfirmed(true);
        ApartmentDebts savedApartmentDebt = apartmentDebtRepository.save(apartmentDebt);
        return savedApartmentDebt.isConfirmed() ? "Debt payment confirmed successfully." : "Debt payment confirmation failed.";
    }

    @Override
    public DtoApartmentDebts getApartmentDebtByFilter(Long id, String token) {
        String email = jwtTokenService.findEmailFromToken(token.replace("Bearer ", ""));
        ApartmentDebts apartmentDebt = apartmentDebtRepository.getReferenceById(id);
        try{
            userService.checkUserIsOwnerOrTenantOfApartment(email, apartmentDebt.getApartmentAccount().getApartment().getId());
        }catch (ApplicationException e){
            userService.checkUserIsManagerOfBuilding(email, apartmentDebt.getApartmentAccount().getApartment().getBuilding().getId());
        }
        return apartmentDebtsMapper.entityToDto(apartmentDebt);
    }
}



================================================
FILE: src/main/java/com/seyitkoc/service/impl/ApartmentServiceImpl.java
================================================
package com.seyitkoc.service.impl;

import com.seyitkoc.service.base.AnnouncementBaseService;
import com.seyitkoc.mapper.AnnouncementMapper;
import com.seyitkoc.dto.announcement.DtoAnnouncement;
import com.seyitkoc.entity.Apartment;
import com.seyitkoc.mapper.ApartmentMapper;
import com.seyitkoc.repository.ApartmentRepository;
import com.seyitkoc.service.IApartmentService;
import com.seyitkoc.dto.apartment.DtoApartment;
import com.seyitkoc.mapper.ApartmentAccountMapper;
import com.seyitkoc.dto.apartmentAccount.DtoApartmentAccount;
import com.seyitkoc.entity.Building;
import com.seyitkoc.common.exception.ApplicationException;
import com.seyitkoc.common.exception.ErrorMessage;
import com.seyitkoc.common.exception.MessageType;
import com.seyitkoc.common.security.JwtTokenService;
import com.seyitkoc.service.IApartmentAccountService;
import com.seyitkoc.service.base.DebtBaseService;
import com.seyitkoc.mapper.DebtMapper;
import com.seyitkoc.dto.debt.DtoDebt;
import com.seyitkoc.service.IUserService;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ApartmentServiceImpl implements IApartmentService {
    private final JwtTokenService jwtTokenService;
    private final IUserService userService;

    private final ApartmentRepository apartmentRepository;
    private final IApartmentAccountService apartmentAccountService;
    private final ApartmentMapper apartmentMapper;

    private final AnnouncementBaseService announcementBaseService;
    private final DebtBaseService debtBaseService;
    private final AnnouncementMapper announcementMapper;
    private final ApartmentAccountMapper apartmentAccountMapper;
    private final DebtMapper debtMapper;

    public ApartmentServiceImpl(JwtTokenService jwtTokenService, IUserService userService, ApartmentRepository apartmentRepository, IApartmentAccountService apartmentAccountService, ApartmentMapper apartmentMapper, AnnouncementBaseService announcementBaseService, DebtBaseService debtBaseService, AnnouncementMapper announcementMapper, ApartmentAccountMapper apartmentAccountMapper, DebtMapper debtMapper) {
        this.jwtTokenService = jwtTokenService;
        this.userService = userService;
        this.apartmentRepository = apartmentRepository;
        this.apartmentAccountService = apartmentAccountService;
        this.apartmentMapper = apartmentMapper;
        this.announcementBaseService = announcementBaseService;
        this.debtBaseService = debtBaseService;
        this.announcementMapper = announcementMapper;
        this.apartmentAccountMapper = apartmentAccountMapper;
        this.debtMapper = debtMapper;
    }

    @Transactional
    @Override
    public void createApartmentsForBuilding(Building building, Long apartmentCount) {
        List<Apartment> apartmentsForAccountCreation = new ArrayList<>();

        if (!building.getApartments().isEmpty()) {
            if (building.getApartments().size() > apartmentCount) {
                List<Apartment> apartmentsToRemove = building.getApartments().stream()
                        .filter(apartment -> apartment.getApartmentNumber() > apartmentCount)
                        .toList();
                building.getApartments().removeAll(apartmentsToRemove);
            }
            if (building.getApartments().size() < apartmentCount) {
                for (int i = building.getApartments().size() + 1; i <= apartmentCount; i++) {
                    Apartment newApartment = createApartment(building, (long) i);
                    building.getApartments().add(newApartment);
                    apartmentsForAccountCreation.add(newApartment);
                }
                apartmentRepository.saveAll(apartmentsForAccountCreation);
                createAccounts(apartmentsForAccountCreation);
            }
        } else {
            for (int i = 1; i <= apartmentCount; i++) {
                Apartment newApartment = createApartment(building, (long) i);
                building.getApartments().add(newApartment);
                apartmentsForAccountCreation.add(newApartment);
            }
            apartmentRepository.saveAll(apartmentsForAccountCreation);
            createAccounts(apartmentsForAccountCreation);
        }
    }
    private Apartment createApartment(Building building, Long apartmentNumber) {
        Apartment apartment = new Apartment();
        apartment.setApartmentNumber(apartmentNumber);
        apartment.setBuilding(building);
        return apartment;
    }
    private void createAccounts(List<Apartment> apartments) {
        apartmentAccountService.createAccounts(apartments);
    }

    @Override
    public Apartment getApartmentById(Long apartmentId) {
        return apartmentRepository.findApartmentById(apartmentId)
                .orElseThrow(() -> new ApplicationException(new ErrorMessage(MessageType.NOT_FOUND, "Apartment not found with id: " + apartmentId)));
    }


    // Read Operation
    @Override
    public DtoApartment getApartmentById(String token, Long apartmentId) {
        String email = jwtTokenService.findEmailFromToken(token.replace("Bearer ", ""));
        Apartment apartment = apartmentRepository.findApartmentById(apartmentId).orElseThrow(() -> new RuntimeException("Apartment not found"));

        userService.checkUserIsMemberOfBuilding(email, apartment.getBuilding().getId());
        return apartmentMapper.toDtoApartment(apartmentRepository.findApartmentById(apartmentId).orElseThrow(() -> new RuntimeException("Apartment not found")));
    }


    // Nested Resources (Sub-resources)
    @Override
    public DtoApartmentAccount getAccountByApartmentId(String token, Long apartmentId) {
        Apartment apartment = getApartmentById(apartmentId);
        String email = jwtTokenService.findEmailFromToken(token.replace("Bearer ", ""));
        try {
            userService.checkUserIsMemberOfBuilding(email, apartment.getBuilding().getId());
        }catch(ApplicationException e){
            userService.checkUserIsOwnerOrTenantOfApartment(email, apartmentId);
        }

        return apartmentAccountMapper.toDto(apartment.getAccount());
    }

    @Override
    public Page<DtoAnnouncement> getAllAnnouncementsByApartmentIdAndFilter(Long apartmentId, String text, LocalDateTime minCreatedAt, LocalDateTime maxCreatedAt, String createdBy, Boolean isRead, int page, int size, String sortBy, String sortDirection, String token) {
        Apartment apartment = getApartmentById(apartmentId);
        String email = jwtTokenService.findEmailFromToken(token.replace("Bearer ", ""));
        try {
            userService.checkUserIsMemberOfBuilding(email, apartment.getBuilding().getId());
        }catch(ApplicationException e){
            userService.checkUserIsOwnerOrTenantOfApartment(email, apartmentId);
        }

        return announcementBaseService.findAnnouncementsByApartmentIdWithFilters(apartmentId, text,
                        minCreatedAt, maxCreatedAt, createdBy, isRead, page, size, sortBy, sortDirection)
                .map(announcementMapper::toDtoAnnouncement);
    }

    @Override
    public Page<DtoDebt> getAllDebtsByApartmentIdAndFilter(Long apartmentId, String text, String type, Double minAmount, Double maxAmount, LocalDateTime minCreatedAt, LocalDateTime maxCreatedAt, int page, int size, String sortBy, String sortDirection, String token) {
        userService.checkUserIsOwnerOrTenantOfApartment(jwtTokenService
                .findEmailFromToken(token.replace("Bearer ","")), apartmentId);

        return debtBaseService
                .getAllDebtsByApartmentIdAndFilter(apartmentId, text, type, minAmount, maxAmount,
                        minCreatedAt, maxCreatedAt, page, size, sortBy, sortDirection)
                .map(debtMapper::entityToDto);
    }


    // Special Operations
    @Override
    @Transactional
    public DtoApartment setApartmentOwner(String token, Long apartmentId, Long userId) {
        String email = jwtTokenService.findEmailFromToken(token.replace("Bearer ", ""));
        Apartment apartment = apartmentRepository.findApartmentById(apartmentId).orElseThrow(() -> new RuntimeException("Apartment not found"));
        if (apartment.getOwner() != null) {
            userService.checkUserIsOwnerOfApartment(email, apartmentId);
            if (apartment.getOwner().getId().equals(userId)) {
                throw new ApplicationException(new ErrorMessage(MessageType.BAD_REQUEST, "This user is already the owner of this apartment."));
            }
            apartment.setOwner(userService.getUserById(userId));
        } else {
            apartment.setOwner(userService.getUserById(userId));
        }
        return apartmentMapper.toDtoApartment(apartmentRepository.save(apartment));
    }

    @Override
    @Transactional
    public DtoApartment setApartmentTenant(String token, Long apartmentId, Long userId) {
        String email = jwtTokenService.findEmailFromToken(token.replace("Bearer ", ""));
        Apartment apartment = apartmentRepository.findApartmentById(apartmentId).orElseThrow(() -> new RuntimeException("Apartment not found"));
        if (apartment.getOwner() != null) {
            userService.checkUserIsOwnerOfApartment(email, apartmentId);
            if (apartment.getTenant() != null && apartment.getTenant().getId().equals(userId)) {
                throw new ApplicationException(new ErrorMessage(MessageType.BAD_REQUEST, "This user is already the tenant of this apartment."));
            }
            apartment.setTenant(userService.getUserById(userId));
        }
        return apartmentMapper.toDtoApartment(apartmentRepository.save(apartment));
    }
}



================================================
FILE: src/main/java/com/seyitkoc/service/impl/AuthServiceImpl.java
================================================
package com.seyitkoc.service.impl;

import com.seyitkoc.entity.Auth;
import com.seyitkoc.mapper.AuthMapper;
import com.seyitkoc.repository.AuthRepository;
import com.seyitkoc.service.IAuthService;
import com.seyitkoc.dto.auth.LoginRequest;
import com.seyitkoc.dto.auth.DtoAuth;
import com.seyitkoc.dto.auth.DtoAuthEmailUpdate;
import com.seyitkoc.dto.auth.DtoAuthPasswordUpdate;
import com.seyitkoc.enums.AuthRole;
import com.seyitkoc.common.exception.ApplicationException;
import com.seyitkoc.common.exception.ErrorMessage;
import com.seyitkoc.common.exception.MessageType;
import com.seyitkoc.common.security.JwtTokenService;
import com.seyitkoc.entity.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements IAuthService {
    private final AuthRepository authRepository;
    private final JwtTokenService jwtTokenService;
    private final AuthMapper authMapper;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(AuthRepository authRepository, JwtTokenService jwtTokenService, AuthMapper authMapper, PasswordEncoder passwordEncoder) {
        this.authRepository = authRepository;
        this.jwtTokenService = jwtTokenService;
        this.authMapper = authMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Auth createNewAuth(String email, String password, User user) {
        checkIsEmailUsable(email);

        Auth auth = new Auth();
        auth.setEmail(email);
        auth.setPassword(new BCryptPasswordEncoder().encode(password));
        auth.setRole(AuthRole.ROLE_USER);
        auth.setUser(user);
        return authRepository.save(auth);
    }

    @Override
    public DtoAuth getAuthInfos(String token) {
        if (jwtTokenService.isTokenBlacklisted(token)) {
            throw new ApplicationException(new ErrorMessage(MessageType.TOKEN_EXPIRED, ""));
        }
        Auth auth = getAuthByToken(token);
        if (auth == null) {
            throw new ApplicationException(new ErrorMessage(MessageType.USER_NOT_FOUND, ""));
        }
        return authMapper.toDtoAuthWithoutToken(auth);
    }

    private void checkIsEmailUsable(String email) {
        if (authRepository.findAuthByEmail(email).isPresent())
            throw new ApplicationException(new ErrorMessage(MessageType.EMAIL_EXISTS, ""));
    }

    @Override
    public String updateAuthPassword(String token, DtoAuthPasswordUpdate dtoAuthPasswordUpdate) {
        if (jwtTokenService.isTokenBlacklisted(token)) {
            throw new ApplicationException(new ErrorMessage(MessageType.TOKEN_EXPIRED, ""));
        }
        Auth auth = getAuthByToken(token);
        if (!passwordEncoder.matches(dtoAuthPasswordUpdate.getOldPassword(), auth.getPassword())) {
            throw new ApplicationException(new ErrorMessage(MessageType.INVALID_CREDENTIALS, ""));
        }
        auth.setPassword(new BCryptPasswordEncoder().encode(dtoAuthPasswordUpdate.getNewPassword()));
        Auth savedAuth = authRepository.save(auth);
        if (savedAuth.getId() == null) {
            throw new ApplicationException(new ErrorMessage(MessageType.INTERNAL_SERVER_ERROR, "Failed to update password"));
        }
        if (!jwtTokenService.isTokenBlacklisted(token)) {
            jwtTokenService.blacklistToken(token);
        }
        return "Password updated successfully.";
    }

    @Override
    public String updateAuthEmail(String token, DtoAuthEmailUpdate dtoAuthEmailUpdate) {
        if (jwtTokenService.isTokenBlacklisted(token)) {
            throw new ApplicationException(new ErrorMessage(MessageType.TOKEN_EXPIRED, ""));
        }
        Auth auth = getAuthByToken(token);
        if (!auth.getEmail().equals(dtoAuthEmailUpdate.getOldEmail()) || !passwordEncoder.matches(dtoAuthEmailUpdate.getPassword(), auth.getPassword())) {
            throw new ApplicationException(new ErrorMessage(MessageType.INVALID_CREDENTIALS, ""));
        }
        checkIsEmailUsable(dtoAuthEmailUpdate.getNewEmail());

        auth.setEmail(dtoAuthEmailUpdate.getNewEmail());
        auth = authRepository.save(auth);
        if (auth.getId() == null) {
            throw new ApplicationException(new ErrorMessage(MessageType.INTERNAL_SERVER_ERROR, "Failed to update email"));
        }
        if (!jwtTokenService.isTokenBlacklisted(token)) {
            jwtTokenService.blacklistToken(token);
        }
        return "Email updated successfully.";
    }

    @Override
    public DtoAuth login(LoginRequest loginRequest) {
        Auth auth = authRepository.findAuthByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new ApplicationException(new ErrorMessage(MessageType.USER_NOT_FOUND, "")));
        if(!passwordEncoder.matches(loginRequest.getPassword(),auth.getPassword())){
            throw new RuntimeException("");
        }
        return authMapper.toDtoAuthWithToken(auth, jwtTokenService.generateToken(auth));
    }

    @Override
    public String deleteAuth(String token) {
        if (jwtTokenService.isTokenBlacklisted(token)) {
            throw new ApplicationException(new ErrorMessage(MessageType.TOKEN_EXPIRED, ""));
        }
        Auth auth = getAuthByToken(token);
        authRepository.delete(auth);
        if (!jwtTokenService.isTokenBlacklisted(token)) {
            jwtTokenService.blacklistToken(token);
        }
        return "User deleted successfully.";
    }


    public Auth getAuthByToken(String token) {
        String email = jwtTokenService.findEmailFromToken(token.replace("Bearer ", "").trim());
        return authRepository.findAuthByEmail(email)
                .orElseThrow(() -> new ApplicationException(new ErrorMessage(MessageType.USER_NOT_FOUND, "")));
    }
}



================================================
FILE: src/main/java/com/seyitkoc/service/impl/BuildingAccountServiceImpl.java
================================================
package com.seyitkoc.service.impl;

import com.seyitkoc.service.IBuildingAccountService;
import com.seyitkoc.entity.BuildingAccount;
import com.seyitkoc.mapper.BuildingAccountMapper;
import com.seyitkoc.repository.BuildingAccountRepository;
import com.seyitkoc.dto.buildingAccount.DtoBuildingAccount;
import com.seyitkoc.dto.buildingAccount.DtoBuildingAccountIU;
import com.seyitkoc.entity.Building;
import com.seyitkoc.enums.AccountType;
import com.seyitkoc.common.exception.ApplicationException;
import com.seyitkoc.common.exception.ErrorMessage;
import com.seyitkoc.common.exception.MessageType;
import com.seyitkoc.repository.BuildingRepository;
import com.seyitkoc.common.security.JwtTokenService;
import com.seyitkoc.service.base.TransactionBaseService;
import com.seyitkoc.mapper.TransactionMapper;
import com.seyitkoc.dto.transaction.DtoTransaction;
import com.seyitkoc.service.IUserService;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BuildingAccountServiceImpl implements IBuildingAccountService {
    private final BuildingAccountRepository buildingAccountRepository;
    private final BuildingRepository buildingRepository;
    private final IUserService userService;
    private final JwtTokenService jwtTokenService;
    private final BuildingAccountMapper buildingAccountMapper;
    private final TransactionBaseService transactionBaseService;
    private final TransactionMapper transactionMapper;

    public BuildingAccountServiceImpl(
            BuildingAccountRepository buildingAccountRepository,
            BuildingRepository buildingRepository,
            IUserService iUserService,
            JwtTokenService jwtTokenService,
            BuildingAccountMapper buildingAccountMapper, TransactionBaseService transactionBaseService, TransactionMapper transactionMapper
    ) {
        this.buildingAccountRepository = buildingAccountRepository;
        this.buildingRepository = buildingRepository;
        this.userService = iUserService;
        this.jwtTokenService = jwtTokenService;
        this.buildingAccountMapper = buildingAccountMapper;
        this.transactionBaseService = transactionBaseService;
        this.transactionMapper = transactionMapper;
    }

    @Override
    @Transactional
    public void createAccountsWhenBuildingCreate(Building building) {
        List<BuildingAccount> cashAccounts = new ArrayList<>();
        cashAccounts.add(new BuildingAccount(null, "Nakit Kasası", LocalDateTime.now().getYear(), 0.0, LocalDateTime.now(), 0.0, AccountType.CASH, LocalDateTime.now(), LocalDateTime.now(), true, building, new ArrayList<>()));
        cashAccounts.add(new BuildingAccount(null, "Banka Kasası", LocalDateTime.now().getYear(), 0.0, LocalDateTime.now(), 0.0, AccountType.BANK, LocalDateTime.now(), LocalDateTime.now(), true, building, new ArrayList<>()));
        buildingAccountRepository.saveAll(cashAccounts);
    }

    @Override
    @Transactional
    public void updateBuildingAccountBalance(Long buildingAccountId) {
        BuildingAccount buildingAccount = buildingAccountRepository.findById(buildingAccountId)
                .orElseThrow(() -> new ApplicationException(new ErrorMessage(MessageType.NOT_FOUND, "Building account not found.")));

        buildingAccount.setBalance(buildingAccount.getBalanceCalculated());
        buildingAccount.setBalanceUpdatedAt(LocalDateTime.now());
        buildingAccountRepository.save(buildingAccount);
    }

    @Override
    @Transactional
    public DtoBuildingAccount createBuildingAccount(String token, DtoBuildingAccountIU dtoBuildingAccountIU) {
        userService.checkUserIsManagerOfBuilding(jwtTokenService.findEmailFromToken(token.replace("Bearer ", "")), dtoBuildingAccountIU.getBuildingId());
        BuildingAccount buildingAccount = buildingAccountMapper.toBuildingAccount(dtoBuildingAccountIU, buildingRepository.findById(dtoBuildingAccountIU.getBuildingId()).orElseThrow(() -> new ApplicationException(new ErrorMessage(MessageType.NOT_FOUND, "Building not found."))));
        return buildingAccountMapper.toDtoBuildingAccount(buildingAccount);
    }

    @Override
    public DtoBuildingAccount getBuildingAccountById(Long id, String token) {
        userService.checkUserIsMemberOfBuilding(jwtTokenService.findEmailFromToken(token.replace("Bearer ", "")), id);

        return buildingAccountMapper.toDtoBuildingAccount(buildingAccountRepository.findById(id)
                .orElseThrow(() -> new ApplicationException(new ErrorMessage(MessageType.NOT_FOUND, "Building account not found."))));
    }

    @Override
    @Transactional
    public DtoBuildingAccount updateBuildingAccount(String token, Long accountId, DtoBuildingAccountIU dtoBuildingAccountIU) {
        userService.checkUserIsManagerOfBuilding(jwtTokenService.findEmailFromToken(token.replace("Bearer ", "")), dtoBuildingAccountIU.getBuildingId());

        BuildingAccount existingAccount = buildingAccountRepository.findById(accountId)
                .orElseThrow(() -> new ApplicationException(new ErrorMessage(MessageType.NOT_FOUND, "Building account not found.")));
        if (!existingAccount.isActive() || !existingAccount.getBuilding().getId().equals(dtoBuildingAccountIU.getBuildingId())) {
            throw new ApplicationException(new ErrorMessage(MessageType.UNAUTHORIZED, "You are not authorized to update this building account."));
        }
        existingAccount.setAccountName(dtoBuildingAccountIU.getName());
        existingAccount.setAccountType(AccountType.valueOf(dtoBuildingAccountIU.getType()));
        existingAccount.setBalance(existingAccount.getBalance() == 0 ? dtoBuildingAccountIU.getBalance() : existingAccount.getBalance());

        return buildingAccountMapper.toDtoBuildingAccount(buildingAccountRepository.save(existingAccount));
    }

    @Override
    public BuildingAccount getBuildingAccountById(Long id) {
        return buildingAccountRepository.findById(id)
                .orElseThrow(() -> new ApplicationException(new ErrorMessage(MessageType.NOT_FOUND, "Building account not found.")));
    }

    @Override
    public Page<DtoTransaction> getAllTransactionsByAccountIdAndFilter(
            Long accountId, String type, String subType, Double minAmount, Double maxAmount, String text,
            String startDate, String endDate, int page, int size, String sortBy, String sortDirection, String token) {

        BuildingAccount buildingAccount = buildingAccountRepository.findById(accountId).orElseThrow(() ->
                new ApplicationException(new ErrorMessage(MessageType.NOT_FOUND, "Building account not found.")));
        userService.checkUserIsMemberOfBuilding(jwtTokenService
                .findEmailFromToken(token.replace("Bearer ", "")), buildingAccount.getBuilding().getId());

        return transactionBaseService.getTransactionsByBuildingAccountIdAndFilter(
                accountId, type, subType, text, minAmount, maxAmount, startDate, endDate, page, size, sortBy, sortDirection)
                .map(transactionMapper::toDto);
    }
}


================================================
FILE: src/main/java/com/seyitkoc/service/impl/BuildingServiceImpl.java
================================================
package com.seyitkoc.service.impl;

import com.seyitkoc.service.base.AnnouncementBaseService;
import com.seyitkoc.mapper.AnnouncementMapper;
import com.seyitkoc.dto.announcement.DtoAnnouncement;
import com.seyitkoc.service.base.ApartmentBaseService;
import com.seyitkoc.mapper.ApartmentMapper;
import com.seyitkoc.service.IApartmentService;
import com.seyitkoc.dto.apartment.DtoApartment;
import com.seyitkoc.service.base.ApartmentAccountBaseService;
import com.seyitkoc.mapper.ApartmentAccountMapper;
import com.seyitkoc.dto.apartmentAccount.DtoApartmentAccount;
import com.seyitkoc.enums.AuthRole;
import com.seyitkoc.entity.Building;
import com.seyitkoc.mapper.BuildingMapper;
import com.seyitkoc.repository.BuildingRepository;
import com.seyitkoc.service.IBuildingService;
import com.seyitkoc.dto.building.DtoBuilding;
import com.seyitkoc.dto.building.DtoBuildingIU;
import com.seyitkoc.service.base.BuildingAccountBaseService;
import com.seyitkoc.mapper.BuildingAccountMapper;
import com.seyitkoc.service.IBuildingAccountService;
import com.seyitkoc.dto.buildingAccount.DtoBuildingAccount;
import com.seyitkoc.service.base.DebtBaseService;
import com.seyitkoc.mapper.DebtMapper;
import com.seyitkoc.dto.debt.DtoDebt;
import com.seyitkoc.service.base.DueBaseService;
import com.seyitkoc.mapper.DueMapper;
import com.seyitkoc.service.IDueService;
import com.seyitkoc.dto.due.DtoDue;
import com.seyitkoc.service.base.PollBaseService;
import com.seyitkoc.mapper.PollMapper;
import com.seyitkoc.dto.poll.DtoPoll;
import com.seyitkoc.service.base.TransactionBaseService;
import com.seyitkoc.mapper.TransactionMapper;
import com.seyitkoc.dto.transaction.DtoTransaction;
import com.seyitkoc.entity.User;
import com.seyitkoc.common.exception.ApplicationException;
import com.seyitkoc.common.security.JwtTokenService;
import com.seyitkoc.service.IUserService;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class BuildingServiceImpl implements IBuildingService {
    private final BuildingRepository buildingRepository;
    private final IUserService userService;
    private final JwtTokenService jwtTokenService;
    private final IApartmentService apartmentService;
    private final IBuildingAccountService buildingAccountService;
    private final BuildingMapper buildingMapper;
    private final IDueService dueService;
    private final ApartmentMapper apartmentMapper;
    private final AnnouncementMapper announcementMapper;
    private final BuildingAccountMapper buildingAccountMapper;
    private final PollMapper pollMapper;
    private final ApartmentBaseService apartmentBaseService;
    private final AnnouncementBaseService announcementBaseService;
    private final BuildingAccountBaseService buildingAccountBaseService;
    private final PollBaseService pollBaseService;
    private final ApartmentAccountBaseService apartmentAccountBaseService;
    private final ApartmentAccountMapper apartmentAccountMapper;
    private final DebtBaseService debtBaseService;
    private final DebtMapper debtMapper;
    private final TransactionBaseService transactionBaseService;
    private final TransactionMapper transactionMapper;
    private final DueBaseService dueBaseService;
    private final DueMapper dueMapper;

    public BuildingServiceImpl(
            BuildingRepository buildingRepository, IUserService userService,
            JwtTokenService jwtTokenService, IApartmentService apartmentService,
            IBuildingAccountService buildingAccountService, BuildingMapper buildingMapper,
            IDueService dueService, ApartmentMapper apartmentMapper,
            AnnouncementMapper announcementMapper, BuildingAccountMapper buildingAccountMapper,
            PollMapper pollMapper, ApartmentBaseService apartmentBaseService,
            AnnouncementBaseService announcementBaseService, BuildingAccountBaseService buildingAccountBaseService,
            PollBaseService pollBaseService, ApartmentAccountBaseService apartmentAccountBaseService,
            ApartmentAccountMapper apartmentAccountMapper, DebtBaseService debtBaseService, DebtMapper debtMapper, TransactionBaseService transactionBaseService, TransactionMapper transactionMapper, DueBaseService dueBaseService, DueMapper dueMapper) {
        this.buildingRepository = buildingRepository;
        this.userService = userService;
        this.jwtTokenService = jwtTokenService;
        this.apartmentService = apartmentService;
        this.buildingAccountService = buildingAccountService;
        this.buildingMapper = buildingMapper;
        this.dueService = dueService;
        this.apartmentMapper = apartmentMapper;
        this.announcementMapper = announcementMapper;
        this.buildingAccountMapper = buildingAccountMapper;
        this.pollMapper = pollMapper;
        this.apartmentBaseService = apartmentBaseService;
        this.announcementBaseService = announcementBaseService;
        this.buildingAccountBaseService = buildingAccountBaseService;
        this.pollBaseService = pollBaseService;
        this.apartmentAccountBaseService = apartmentAccountBaseService;
        this.apartmentAccountMapper = apartmentAccountMapper;
        this.debtBaseService = debtBaseService;
        this.debtMapper = debtMapper;
        this.transactionBaseService = transactionBaseService;
        this.transactionMapper = transactionMapper;
        this.dueBaseService = dueBaseService;
        this.dueMapper = dueMapper;
    }

    @Override
    public Building getBuildingById(Long buildingId) {
        return buildingRepository.findById(buildingId)
                .orElseThrow(() -> new IllegalArgumentException("Building not found"));
    }

    // CRUD
    @Transactional
    @Override
    public String saveBuilding(DtoBuildingIU dtoBuildingIU) {
        Building building = buildingMapper.toBuilding(dtoBuildingIU);
        Building savedBuilding = buildingRepository.save(building);
        dueService.createDue("1", 1.0, savedBuilding);
        if (savedBuilding.getId() == null) {
            throw new IllegalArgumentException("Building could not be saved");
        }
        apartmentService.createApartmentsForBuilding(savedBuilding, dtoBuildingIU.getApartmentCount());
        buildingAccountService.createAccountsWhenBuildingCreate(savedBuilding);
        return "Building saved successfully.";
    }

    @Override
    public Page<DtoBuilding> getAllBuildings(int page, int size, String sortBy, String sortDirection) {
        return buildingRepository
                .findAll(PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortBy)))
                .map(buildingMapper::toDtoBuilding);
    }

    @Override
    public DtoBuilding getBuildingById(String token, Long buildingId) {
        User user = userService.getUserByEmail(jwtTokenService
                .findEmailFromToken(token.replace("Bearer ", "")));

        if (!user.getAuth().getRole().equals(AuthRole.valueOf("ROLE_ADMIN"))) {
            userService.checkUserIsMemberOfBuilding(jwtTokenService.findEmailFromToken(token.replace("Bearer ", "")), buildingId);
        }
        Building building = buildingRepository.findById(buildingId).orElseThrow(() -> new IllegalArgumentException("Building not found"));
        return buildingMapper.toDtoBuilding(building);
    }

    @Transactional
    @Override
    public String updateBuilding(DtoBuildingIU dtoBuildingIU, Long id, String token) {
        try {
            userService.checkUserIsManagerOfBuilding(jwtTokenService
                    .findEmailFromToken(token.replace("Bearer ", "")), id);
        } catch (ApplicationException e) {
            throw new IllegalArgumentException("User not found or invalid token");
        }
        Building building = buildingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Building not found"));

        Optional.ofNullable(dtoBuildingIU.getName())
                .filter(name -> !name.isBlank())
                .ifPresent(building::setName);

        Optional.ofNullable(dtoBuildingIU.getAddress())
                .filter(address -> !address.isBlank())
                .ifPresent(building::setAddress);

        Optional.ofNullable(dtoBuildingIU.getFloorCount())
                .filter(floorCount -> !floorCount.equals(building.getFloorCount()))
                .ifPresent(building::setFloorCount);

        Optional.ofNullable(dtoBuildingIU.getApartmentCount())
                .filter(apartmentCount -> !apartmentCount.equals(building.getApartmentCount()))
                .ifPresent(newCount -> {
                    apartmentService.createApartmentsForBuilding(building, newCount);
                    building.setApartmentCount(newCount);
                });

        buildingRepository.save(building);
        return "Building updated successfully.";
    }

    @Transactional
    @Override
    public String deleteBuilding(Long id) {
        Building building = buildingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Building not found"));
        if (building.isActive()) {
            throw new IllegalArgumentException("Building is active");
        }
        buildingRepository.delete(building);
        return "Building deleted successfully.";
    }

    // Nested Resources
    @Override
    public Page<DtoApartment> getAllApartmentsByBuildingId(
            String token, Long buildingId, int page, int size, String sortBy, String sortDirection) {
        userService.checkUserIsMemberOfBuilding(jwtTokenService
                .findEmailFromToken(token.replace("Bearer ", "")), buildingId);

        return apartmentBaseService.getAllApartmentsByBuildingId(buildingId, page, size, sortBy, sortDirection)
                .map(apartmentMapper::toDtoApartment);
    }

    @Override
    public Page<DtoApartmentAccount> getAllApartmentAccountsByBuildingId(
            Long buildingId, int page, int size, String sortBy, String sortDirection, String token) {
        userService.checkUserIsManagerOfBuilding(jwtTokenService
                .findEmailFromToken(token.replace("Bearer ", "")), buildingId);

        return apartmentAccountBaseService.getAccountsByBuildingId(buildingId, page, size, sortBy, sortDirection)
                .map(apartmentAccountMapper::toDto);
    }

    @Override
    public Page<DtoAnnouncement> getAnnouncementsByBuildingId(
            String token, Long buildingId, String text,
            LocalDateTime minCreatedAt, LocalDateTime maxCreatedAt, String createdBy,
            int page, int size, String sortBy, String sortDirection
    ) {
        userService.checkUserIsManagerOfBuilding(jwtTokenService
                .findEmailFromToken(token.replace("Bearer ", "")), buildingId);

        return announcementBaseService.findAnnouncementsByBuildingIdWithFilters(buildingId, text,
                        minCreatedAt, maxCreatedAt, createdBy,
                        page, size, sortBy, sortDirection)
                .map(announcementMapper::toDtoAnnouncement);
    }

    @Override
    public Page<DtoBuildingAccount> getAllBuildingAccountsByBuildingId(
            Long buildingId, int year, int page, int size, String sortBy, String sortDirection, String token) {
        userService.checkUserIsMemberOfBuilding(jwtTokenService
                .findEmailFromToken(token.replace("Bearer ", "")), buildingId);

        return buildingAccountBaseService.getAllAccountsByBuildingId(buildingId, year,
                        page, size, sortBy, sortDirection)
                .map(buildingAccountMapper::toDtoBuildingAccount);
    }

    @Override
    public Page<DtoDebt> getAllDebtsByBuildingIdAndFilter(
            Long buildingId, String text, String type, Double minAmount, Double maxAmount,
            LocalDateTime minCreatedAt, LocalDateTime maxCreatedAt, int page, int size,
            String sortBy, String sortDirection, String token) {
        userService.checkUserIsManagerOfBuilding(jwtTokenService
                .findEmailFromToken(token.replace("Bearer ","")), buildingId);

        return debtBaseService.getAllDebtsByBuildingIdAndFilter(buildingId, text, type, minAmount, maxAmount,
                minCreatedAt, maxCreatedAt, page, size, sortBy, sortDirection)
                .map(debtMapper::entityToDto);
    }

    @Override
    public Page<DtoTransaction> getAllTransactionsByBuildingIdAndFilter(
            String token, Long id, String type, String subType, Double minAmount, Double maxAmount, String text,
            String startDate, String endDate, int page, int size, String sortBy, String sortDirection) {
        userService.checkUserIsMemberOfBuilding(jwtTokenService
                .findEmailFromToken(token.replace("Bearer ", "")), id );

        return transactionBaseService
                .getTransactionsByBuildingIdAndFilter(id, type, subType, text, minAmount, maxAmount, startDate, endDate,
                        page, size, sortBy, sortDirection)
                .map(transactionMapper::toDto);
    }

    @Override
    public DtoDue getDueByBuildingId(Long buildingId, String token) {
        userService.checkUserIsMemberOfBuilding(jwtTokenService
                .findEmailFromToken(token.replace("Bearer ", "")), buildingId);

        return dueMapper.toDtoDue(dueBaseService.getDueByBuildingId(buildingId));
    }

    @Override
    public Page<DtoPoll> getAllPollsByBuildingId(
            Long buildingId, String text,
            LocalDateTime minCreatedAt, LocalDateTime maxCreatedAt, boolean isFinished,
            int page, int size, String sortBy, String sortDirection, String token) {
        userService.checkUserIsMemberOfBuilding(jwtTokenService
                .findEmailFromToken(token.replace("Bearer ", "")), buildingId);

        return pollBaseService.getAllPollsByBuildingIdAndFilter(buildingId, text,
                        minCreatedAt, maxCreatedAt, isFinished,
                        page, size, sortBy, sortDirection)
                .map(pollMapper::pollToDtoPoll);
    }

    // Special Operations
    @Override
    @Transactional
    public String updateBuildingStatus(Long id, String status) {
        Building building = buildingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Building not found"));
        if (status.equals("active") && !building.isActive()) {
            building.setActive(true);
        } else if (status.equals("passive") && building.isActive()) {
            building.setActive(false);
        } else {
            throw new IllegalArgumentException("Invalid status change request");
        }
        buildingRepository.save(building);
        return "Building status updated successfully";
    }

    @Override
    @Transactional
    public DtoBuilding changeManager(Long buildingId, Long managerId) {
        Building building = buildingRepository.findById(buildingId)
                .orElseThrow(() -> new IllegalArgumentException("Building not found"));
        if (building.getManager() != null && building.getManager().getId().equals(managerId)) {
            throw new IllegalArgumentException("This user is already the manager of the building.");
        }
        building.setManager(userService.getUserById(managerId));
        return buildingMapper.toDtoBuilding(buildingRepository.save(building));
    }
}



================================================
FILE: src/main/java/com/seyitkoc/service/impl/DebtServiceImpl.java
================================================
package com.seyitkoc.service.impl;

import com.seyitkoc.service.*;
import com.seyitkoc.service.base.ApartmentDebtsBaseService;
import com.seyitkoc.mapper.ApartmentDebtsMapper;
import com.seyitkoc.dto.apartmentDebts.DtoApartmentDebts;
import com.seyitkoc.entity.Debt;
import com.seyitkoc.mapper.DebtMapper;
import com.seyitkoc.repository.DebtRepository;
import com.seyitkoc.dto.debt.DtoDebt;
import com.seyitkoc.dto.debt.DtoDebtIU;
import com.seyitkoc.entity.Apartment;
import com.seyitkoc.entity.Building;
import com.seyitkoc.entity.ApartmentDebts;
import com.seyitkoc.entity.Due;
import com.seyitkoc.enums.DebtType;
import com.seyitkoc.common.exception.ApplicationException;
import com.seyitkoc.common.exception.ErrorMessage;
import com.seyitkoc.common.exception.MessageType;
import com.seyitkoc.common.security.JwtTokenService;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DebtServiceImpl implements IDebtService {
    private final DebtRepository debtRepository;
    private final IUserService userService;
    private final IBuildingService buildingService;
    private final IApartmentDebtsService apartmentDebtService;
    private final JwtTokenService jwtTokenService;
    private final DebtMapper debtMapper;
    private final IAnnouncementService announcementService;
    private final IDueService dueService;
    private final ApartmentDebtsBaseService apartmentDebtsBaseService;
    private final ApartmentDebtsMapper apartmentDebtsMapper;

    public DebtServiceImpl(
            DebtRepository debtRepository,
            JwtTokenService jwtTokenService,
            IUserService userService,
            IBuildingService buildingService,
            IApartmentDebtsService apartmentDebtService,
            DebtMapper debtMapper, IAnnouncementService announcementService, IDueService dueService,
            ApartmentDebtsBaseService apartmentDebtsBaseService, ApartmentDebtsMapper apartmentDebtsMapper) {
        this.debtRepository = debtRepository;
        this.jwtTokenService = jwtTokenService;
        this.userService = userService;
        this.buildingService = buildingService;
        this.apartmentDebtService = apartmentDebtService;
        this.debtMapper = debtMapper;
        this.announcementService = announcementService;
        this.dueService = dueService;
        this.apartmentDebtsBaseService = apartmentDebtsBaseService;
        this.apartmentDebtsMapper = apartmentDebtsMapper;
    }


    @Override
    @Transactional
    public void createDueDebt(Due due) {
        Debt debt = debtMapper.dtoToEntity(
                new DtoDebtIU(
                        "Due Payment for " + due.getDayOfMonth() + " of the month",
                        due.getDueAmount(),
                        DebtType.DUES.name(),
                        due.getBuilding().getId(),
                        due.getBuilding().getApartments().stream()
                                .map(Apartment::getId)
                                .collect(Collectors.toSet())
                )
        );

        Debt savedDebt = debtRepository.save(debt);
        createAnnouncementForDebt(savedDebt, "Due Payment Created",
                "A new due payment has been created for the building: " + due.getBuilding().getName() + ".\n" +
                        "Due Date: " + due.getDayOfMonth() + "\n" +
                        "Amount: " + due.getDueAmount() + "\n" +
                        "Type: " + DebtType.DUES.name(),
                "system", due.getBuilding());

    }

    private void createAnnouncementForDebt(Debt debt, String title, String description, String createdBy, Building building) {
        announcementService.createAnnouncement(title,
                description,
                createdBy,
                building.getId(),
                debt.getApartmentDebts().stream()
                        .map(apartmentDebt -> apartmentDebt.getApartmentAccount().getApartment().getId())
                        .collect(Collectors.toList()));

    }

    @Override
    @Transactional
    public DtoDebt createDebt(String token, DtoDebtIU dtoDebtIU) {
        userService.checkUserIsManagerOfBuilding(jwtTokenService.findEmailFromToken(token.replace("Bearer ", "")), dtoDebtIU.getBuildingId());
        Building building = buildingService.getBuildingById(dtoDebtIU.getBuildingId());

        checkApartmentsAreInBuilding(building, dtoDebtIU.getApartmentIds());

        Debt debt = debtRepository.save(debtMapper.dtoToEntity(dtoDebtIU));
        apartmentDebtService.setDebtToApartments(debt, building, new ArrayList<>(dtoDebtIU.getApartmentIds()));

        createAnnouncementForDebt(debt, "Debt Created",
                "A new debt has been created for the building: " + building.getName() + ".\n" +
                        "Description: " + dtoDebtIU.getDescription() + "\n" +
                        "Amount: " + dtoDebtIU.getAmount() + "\n" +
                        "Type: " + dtoDebtIU.getType(),
                "manager", building);

        return debtMapper.entityToDto(debt);
    }

    private void checkApartmentsAreInBuilding(Building building, Set<Long> apartmentIds) {
        if (!building.getApartments().stream().map(Apartment::getId).collect(Collectors.toSet()).containsAll(apartmentIds))
            throw new ApplicationException(new ErrorMessage(MessageType.ERROR, "Some of the apartment IDs provided do not belong to the building."));
    }

    @Override
    @Transactional
    public DtoDebt updateDebt(String token, Long debtId, DtoDebtIU dtoDebtIU) {
        userService.checkUserIsManagerOfBuilding(jwtTokenService.findEmailFromToken(token.replace("Bearer ", "")), dtoDebtIU.getBuildingId());
        Debt debt = debtRepository.findById(debtId)
                .orElseThrow(() -> new ApplicationException(new ErrorMessage(MessageType.NOT_FOUND, "Debt not found.")));
        if (debt.getApartmentDebts().stream().anyMatch(ApartmentDebts::isPaid)) {
            throw new ApplicationException(new ErrorMessage(MessageType.ERROR, "Cannot update a debt that has already been paid."));
        }

        checkApartmentsAreInBuilding(buildingService.getBuildingById(dtoDebtIU.getBuildingId()), dtoDebtIU.getApartmentIds());

        debt.setAmount(dtoDebtIU.getAmount());
        debt.setDescription(dtoDebtIU.getDescription());
        debt.setType(DebtType.valueOf(dtoDebtIU.getType()));
        debt.setUpdatedAt(LocalDateTime.now());

        Debt updatedDebt = debtRepository.save(debt);

        if (!debt.getApartmentDebts().stream().map(apartmentdebts -> apartmentdebts.getApartmentAccount().getApartment().getId())
                .collect(Collectors.toSet()).containsAll(dtoDebtIU.getApartmentIds())) {
            apartmentDebtService.updateApartmentDebts(updatedDebt, buildingService.getBuildingById(updatedDebt.getBuildingId()), new ArrayList<>(dtoDebtIU.getApartmentIds()));
        }

        announcementService.createAnnouncement("Debt Updated",
                "A debt has been updated for the building: " + buildingService.getBuildingById(updatedDebt.getBuildingId()).getName() + ".\n" +
                        "Description: " + dtoDebtIU.getDescription() + "\n" +
                        "Amount: " + dtoDebtIU.getAmount() + "\n" +
                        "Type: " + dtoDebtIU.getType(),
                "system",
                updatedDebt.getBuildingId(),
                new ArrayList<>(dtoDebtIU.getApartmentIds()));

        return debtMapper.entityToDto(updatedDebt);
    }

    @Override
    public DtoDebt getDebtById(String token, Long debtId) {
        userService.checkUserIsManagerOfBuilding(jwtTokenService.findEmailFromToken(token.replace("Bearer ", "")), debtId);
        return debtMapper.entityToDto(debtRepository.findById(debtId)
                .orElseThrow(() -> new ApplicationException(new ErrorMessage(MessageType.NOT_FOUND, "Debt not found.")))
        );
    }

    @Override
    @Transactional
    public String deleteDebt(String token, Long debtId) {
        userService.checkUserIsManagerOfBuilding(jwtTokenService.findEmailFromToken(token.replace("Bearer ", "")), debtId);
        Debt debt = debtRepository.findById(debtId)
                .orElseThrow(() -> new ApplicationException(new ErrorMessage(MessageType.NOT_FOUND, "Debt not found.")));
        if (debt.getApartmentDebts().stream().anyMatch(ApartmentDebts::isPaid)) {
            throw new ApplicationException(new ErrorMessage(MessageType.ERROR, "Cannot delete a debt that has already been paid."));
        }
        debtRepository.delete(debt);
        return "Debt deleted successfully.";
    }

    @Override
    public Page<DtoApartmentDebts> getApartmentDebtsByDebtIdAndFilter(Long debtId, Boolean isPaid, Boolean isConfirm, int page, int pageSize, String sortBy, String sortDirection, String token) {
        Debt debt = debtRepository.findById(debtId).orElseThrow(() ->
                new ApplicationException(new ErrorMessage(MessageType.NOT_FOUND, "Debt not found.")));
        userService.checkUserIsManagerOfBuilding(jwtTokenService
                .findEmailFromToken(token.replace("Bearer ", "")), debt.getBuildingId());

        return apartmentDebtsBaseService
                .getApartmentDebtsByDebtId(debtId, isPaid, isConfirm, page, pageSize, sortBy, sortDirection)
                .map(apartmentDebtsMapper::entityToDto);
    }


    @Scheduled(cron = "0 0 1 * * ?") // Every day at 01:00 AM
    @Transactional
    protected void createDuesForAllBuildings() {
        List<Due> dueList = dueService.findAllByDayOfMonth();
        if (!dueList.isEmpty()) {
            for (Due due : dueList) {
                createDueDebt(due);
            }
        }
    }
}



================================================
FILE: src/main/java/com/seyitkoc/service/impl/DueServiceImpl.java
================================================
package com.seyitkoc.service.impl;

import com.seyitkoc.common.exception.ApplicationException;
import com.seyitkoc.common.exception.ErrorMessage;
import com.seyitkoc.common.exception.MessageType;
import com.seyitkoc.entity.Due;
import com.seyitkoc.mapper.DueMapper;
import com.seyitkoc.repository.DueRepository;
import com.seyitkoc.service.IDueService;
import com.seyitkoc.dto.due.DtoDue;
import com.seyitkoc.dto.due.DtoDueUpdate;
import com.seyitkoc.entity.Building;
import com.seyitkoc.common.security.JwtTokenService;
import com.seyitkoc.service.IUserService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class DueServiceImpl implements IDueService {
    private final DueRepository dueRepository;
    private final IUserService userService;
    private final JwtTokenService jwtTokenService;
    private final DueMapper dueMapper;


    public DueServiceImpl(DueRepository dueRepository, IUserService userService, JwtTokenService jwtTokenService, DueMapper dueMapper) {
        this.dueRepository = dueRepository;
        this.userService = userService;
        this.jwtTokenService = jwtTokenService;
        this.dueMapper = dueMapper;
    }

    @Override
    public List<Due> findAllByDayOfMonth() {
        return dueRepository.findAllByDayOfMonth(String.valueOf(LocalDate.now().getDayOfMonth()));
    }

    @Override
    public void createDue(String dayOfMonth, Double amount, Building building) {
        Due due = Due.builder()
                .dayOfMonth(dayOfMonth)
                .dueAmount(amount)
                .building(building)
                .build();

        dueRepository.save(due);
    }

    @Override
    public DtoDue updateDue(DtoDueUpdate dtoDueUpdate, Long dueId, String token) {
        Due due = dueRepository.findDueById(dueId)
                .orElseThrow(()-> new ApplicationException(new ErrorMessage(MessageType.NOT_FOUND,"")));

        userService.checkUserIsManagerOfBuilding(jwtTokenService
                .findEmailFromToken(token.replace("Bearer ", "")), due.getBuilding().getId());

        due.setDayOfMonth(dtoDueUpdate.getDayOfMonth());
        due.setDueAmount(dtoDueUpdate.getAmount());

        return dueMapper.toDtoDue(dueRepository.save(due));
    }

    @Override
    public DtoDue getDueByBuildingId(Long dueId, String token) {
        Due due = dueRepository.findDueById(dueId)
                .orElseThrow(()-> new ApplicationException(new ErrorMessage(MessageType.NOT_FOUND,"")));
        userService.checkUserIsMemberOfBuilding(jwtTokenService
                .findEmailFromToken(token.replace("Bearer ", "")), due.getBuilding().getId());

        return dueMapper.toDtoDue(due);
    }
}



================================================
FILE: src/main/java/com/seyitkoc/service/impl/PollOptionServiceImpl.java
================================================
package com.seyitkoc.service.impl;

import com.seyitkoc.service.IPollOptionService;
import com.seyitkoc.entity.Poll;
import com.seyitkoc.entity.PollOption;
import com.seyitkoc.repository.PollOptionRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PollOptionServiceImpl implements IPollOptionService {
    private final PollOptionRepository pollOptionRepository;

    public PollOptionServiceImpl(PollOptionRepository pollOptionRepository) {
        this.pollOptionRepository = pollOptionRepository;
    }

    @Override
    @Transactional
    public void createPollOption(Poll poll, List<String> options) {
        List<PollOption> pollOptions = options.stream()
                .map(option -> {
                    PollOption pollOption = new PollOption();
                    pollOption.setPoll(poll);
                    pollOption.setOptionText(option);
                    return pollOption;
                })
                .collect(Collectors.toList());
        pollOptionRepository.saveAll(pollOptions);
    }
}



================================================
FILE: src/main/java/com/seyitkoc/service/impl/PollServiceImpl.java
================================================
package com.seyitkoc.service.impl;

import com.seyitkoc.common.exception.ApplicationException;
import com.seyitkoc.common.exception.ErrorMessage;
import com.seyitkoc.common.exception.MessageType;
import com.seyitkoc.service.IPollService;
import com.seyitkoc.entity.Poll;
import com.seyitkoc.mapper.PollMapper;
import com.seyitkoc.repository.PollRepository;
import com.seyitkoc.dto.poll.DtoPollResult;
import com.seyitkoc.entity.Apartment;
import com.seyitkoc.entity.Building;
import com.seyitkoc.service.base.PollOptionBaseService;
import com.seyitkoc.mapper.PollOptionMapper;
import com.seyitkoc.dto.pollOption.DtoPollOption;
import com.seyitkoc.entity.User;
import com.seyitkoc.dto.poll.DtoPoll;
import com.seyitkoc.dto.poll.DtoPollIU;
import com.seyitkoc.common.security.JwtTokenService;
import com.seyitkoc.service.IAnnouncementService;
import com.seyitkoc.service.IPollOptionService;
import com.seyitkoc.service.IUserService;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PollServiceImpl implements IPollService {
    private final PollRepository pollRepository;
    private final IPollOptionService pollOptionService;
    private final IUserService userService;
    private final JwtTokenService jwtTokenService;
    private final PollMapper pollMapper;
    private final IAnnouncementService announcementService;
    private final PollOptionBaseService pollOptionBaseService;
    private final PollOptionMapper pollOptionMapper;

    public PollServiceImpl(PollRepository pollRepository, IPollOptionService pollOptionService, IUserService userService, JwtTokenService jwtTokenService, PollMapper pollMapper, IAnnouncementService announcementService, PollOptionBaseService pollOptionBaseService, PollOptionMapper pollOptionMapper) {
        this.pollRepository = pollRepository;
        this.pollOptionService = pollOptionService;
        this.userService = userService;
        this.jwtTokenService = jwtTokenService;
        this.pollMapper = pollMapper;
        this.announcementService = announcementService;
        this.pollOptionBaseService = pollOptionBaseService;
        this.pollOptionMapper = pollOptionMapper;
    }

    @Transactional
    @Override
    public DtoPoll createPoll(DtoPollIU dtoPollIU, String token) {
        User user = userService.getUserByEmail(jwtTokenService.findEmailFromToken(token.replace("Bearer ", "")));

        userService.checkUserIsManagerOfBuilding(user, dtoPollIU.getBuildingId());
        Building building = user.getManagedBuildings().stream().filter(building1 -> building1.getId().equals(dtoPollIU.getBuildingId())).findFirst().orElseThrow(() -> new RuntimeException("Building not found"));
        Poll poll = new Poll();
        poll.setBuilding(building);
        poll.setTitle(dtoPollIU.getTitle());
        poll.setDescription(dtoPollIU.getDescription());
        poll.setActive(true);
        poll.setCreatedAt(LocalDateTime.now());
        poll.setFinishDate(LocalDateTime.now().plusDays(dtoPollIU.getTimeLimit()));
        Poll savedPoll = pollRepository.save(poll);
        pollOptionService.createPollOption(savedPoll, dtoPollIU.getOptions());

        announcementService.createAnnouncement("New Poll Created",
                "A new poll has been created: " + dtoPollIU.getTitle(),
                "system",
                building.getId(),
                building.getApartments().stream().map(Apartment::getId).toList()
        );


        return pollMapper.pollToDtoPoll(poll);
    }

    @Override
    public DtoPoll getPollById(Long pollId, String token) {
        Poll poll = pollRepository.findById(pollId).orElseThrow(() -> new RuntimeException("Poll not found"));

        userService.checkUserIsMemberOfBuilding(jwtTokenService.findEmailFromToken(token.replace("Bearer ", "")), poll.getBuilding().getId());
        return pollMapper.pollToDtoPoll(poll);
    }

    @Override
    @Transactional
    public String activatePoll(Long pollId, String token) {
        Poll poll = pollRepository.findById(pollId).orElseThrow(() -> new RuntimeException("Poll not found"));

        userService.checkUserIsMemberOfBuilding(jwtTokenService.findEmailFromToken(token.replace("Bearer ", "")), poll.getBuilding().getId());
        if (poll.isActive()) {
            throw new RuntimeException("Poll is already active.");
        }
        poll.setActive(true);
        pollRepository.save(poll);
        return "Poll activated successfully.";
    }

    @Override
    @Transactional
    public String deactivatePoll(Long pollId, String token) {
        Poll poll = pollRepository.findById(pollId).orElseThrow(() -> new RuntimeException("Poll not found"));
        userService.checkUserIsManagerOfBuilding(jwtTokenService.findEmailFromToken(token.replace("Bearer ", "")), poll.getBuilding().getId());
        if (!poll.isActive()) {
            throw new RuntimeException("Poll is already not active.");
        }
        poll.setActive(false);
        pollRepository.save(poll);
        return "Poll deactivated successfully.";
    }


    @Override
    public DtoPollResult getPollResultById(Long pollId, String token) {
        Poll poll = pollRepository.findById(pollId).orElseThrow(() -> new RuntimeException("Poll not found"));

        userService.checkUserIsMemberOfBuilding(jwtTokenService.findEmailFromToken(token.replace("Bearer ", "")), poll.getBuilding().getId());
        return pollMapper.pollToDtoPollResult(poll);
    }

    @Override
    @Transactional
    public String updatePoll(Long pollId, DtoPollIU dtoPollIU, String token) {
        Poll poll = pollRepository.findById(pollId).orElseThrow(() -> new RuntimeException("Poll not found"));

        userService.checkUserIsManagerOfBuilding(jwtTokenService.findEmailFromToken(token.replace("Bearer ", "")), poll.getBuilding().getId());
        if (!dtoPollIU.getBuildingId().equals(poll.getBuilding().getId())) {
            throw new RuntimeException("Building IDs don't match!");
        }
        poll.setTitle(dtoPollIU.getTitle());
        poll.setDescription(dtoPollIU.getDescription());
        poll.setFinishDate(LocalDateTime.now().plusDays(dtoPollIU.getTimeLimit()));

        List<String> newOptionTexts = dtoPollIU.getOptions().stream().filter(optionText -> poll.getOptions().stream().noneMatch(option -> option.getOptionText().equals(optionText))).toList();
        if (!newOptionTexts.isEmpty()) {
            pollOptionService.createPollOption(poll, newOptionTexts);
        }

        poll.getOptions().removeIf(option ->
                dtoPollIU.getOptions().stream().noneMatch(text -> text.equals(option.getOptionText()))
        );
        Poll savedPoll = pollRepository.save(poll);

        announcementService.createAnnouncement("Poll Updated",
                "The poll has been updated: " + dtoPollIU.getTitle(),
                "system",
                savedPoll.getBuilding().getId(),
                savedPoll.getBuilding().getApartments().stream().map(Apartment::getId).toList()
        );
        return "Poll updated successfully.";
    }

    @Override
    public Page<DtoPollOption> getPollOptionsByPollId(
            Long pollId, int page, int pageSize, String sortBy, String sortDirection, String token) {
        Poll poll = pollRepository.findById(pollId).orElseThrow(() ->
                new ApplicationException(new ErrorMessage(MessageType.NOT_FOUND, "Poll not found")));
        userService.checkUserIsMemberOfBuilding(jwtTokenService
                .findEmailFromToken(token.replace("Bearer ", "")), poll.getBuilding().getId());

        return pollOptionBaseService.getPollOptionsByPollId(pollId, page, pageSize, sortBy, sortDirection)
                .map(pollOptionMapper::pollOptionToDtoPollOption);
    }
}



================================================
FILE: src/main/java/com/seyitkoc/service/impl/TransactionServiceImpl.java
================================================
package com.seyitkoc.service.impl;

import com.seyitkoc.service.ITransactionService;
import com.seyitkoc.mapper.TransactionMapper;
import com.seyitkoc.repository.TransactionRepository;
import com.seyitkoc.specification.TransactionSpecification;
import com.seyitkoc.dto.transaction.DtoTransaction;
import com.seyitkoc.dto.transaction.DtoTransactionIU;
import com.seyitkoc.entity.BuildingAccount;
import com.seyitkoc.entity.transaction.Transaction;
import com.seyitkoc.common.security.JwtTokenService;
import com.seyitkoc.service.IBuildingAccountService;
import com.seyitkoc.service.IUserService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements ITransactionService {
    private final TransactionRepository transactionRepository;
    private final IBuildingAccountService buildingAccountService;
    private final IUserService userService;
    private final JwtTokenService jwtTokenService;
    private final TransactionMapper transactionMapper;

    public TransactionServiceImpl(TransactionRepository transactionRepository, IBuildingAccountService buildingAccountService, IUserService userService, JwtTokenService jwtTokenService, TransactionMapper transactionMapper) {
        this.transactionRepository = transactionRepository;
        this.buildingAccountService = buildingAccountService;
        this.userService = userService;
        this.jwtTokenService = jwtTokenService;
        this.transactionMapper = transactionMapper;
    }

    @Override
    @Transactional
    public DtoTransaction createTransaction(DtoTransactionIU dtoTransactionIU, String token) {
        BuildingAccount buildingAccount = buildingAccountService.getBuildingAccountById(dtoTransactionIU.getBuildingAccountId());
        userService.checkUserIsManagerOfBuilding(jwtTokenService.findEmailFromToken(token.replace("Bearer ", "")), buildingAccount.getBuilding().getId());

        Transaction transaction = transactionRepository.save(transactionMapper.toEntity(dtoTransactionIU, buildingAccount));
        buildingAccountService.updateBuildingAccountBalance(transaction.getBuildingAccount().getId());
        return transactionMapper.toDto(transaction);
    }

    @Override
    public DtoTransaction getTransactionById(String token, Long id) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
        userService.checkUserIsMemberOfBuilding(jwtTokenService.findEmailFromToken(token.replace("Bearer ", "")), transaction.getBuildingId());
        return transactionMapper.toDto(transaction);
    }

    @Override
    @Transactional
    public DtoTransaction updateTransaction(DtoTransactionIU dtoTransaction, String token, Long id) {
        Transaction existingTransaction = transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
        userService.checkUserIsManagerOfBuilding(jwtTokenService.findEmailFromToken(token.replace("Bearer ", "")), existingTransaction.getBuildingId());

        Transaction updatedTransaction = transactionMapper.toEntity(dtoTransaction,
                existingTransaction.getBuildingAccount().getId().equals(dtoTransaction.getBuildingAccountId()) ?
                        existingTransaction.getBuildingAccount() : buildingAccountService.getBuildingAccountById(dtoTransaction.getBuildingAccountId()));
        updatedTransaction.setId(id);

        Transaction savedTransaction = transactionRepository.save(updatedTransaction);
        buildingAccountService.updateBuildingAccountBalance(savedTransaction.getBuildingAccount().getId());
        return transactionMapper.toDto(savedTransaction);
    }

    @Override
    @Transactional
    public void deleteTransaction(String token, Long id) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
        userService.checkUserIsManagerOfBuilding(jwtTokenService.findEmailFromToken(token.replace("Bearer ", "")), transaction.getBuildingId());
        transactionRepository.delete(transaction);
        buildingAccountService.updateBuildingAccountBalance(transaction.getBuildingAccount().getId());
    }

}



================================================
FILE: src/main/java/com/seyitkoc/service/impl/UserServiceImpl.java
================================================
package com.seyitkoc.service.impl;

import com.seyitkoc.service.IUserService;
import com.seyitkoc.service.base.ApartmentBaseService;
import com.seyitkoc.mapper.ApartmentMapper;
import com.seyitkoc.dto.apartment.DtoApartment;
import com.seyitkoc.service.base.BuildingBaseService;
import com.seyitkoc.mapper.BuildingMapper;
import com.seyitkoc.dto.building.DtoBuilding;
import com.seyitkoc.entity.User;
import com.seyitkoc.mapper.UserMapper;
import com.seyitkoc.repository.UserRepository;
import com.seyitkoc.dto.user.DtoUser;
import com.seyitkoc.dto.user.DtoUserCreate;
import com.seyitkoc.dto.user.DtoUserUpdate;
import com.seyitkoc.entity.Auth;
import com.seyitkoc.common.exception.ApplicationException;
import com.seyitkoc.common.exception.ErrorMessage;
import com.seyitkoc.common.exception.MessageType;
import com.seyitkoc.common.security.JwtTokenService;
import com.seyitkoc.service.IAuthService;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service

public class UserServiceImpl implements IUserService {
    private final IAuthService authService;
    private final UserRepository userRepository;
    private final JwtTokenService jwtTokenService;
    private final UserMapper userMapper;
    private final ApartmentBaseService apartmentBaseService;
    private final ApartmentMapper apartmentMapper;
    private final BuildingBaseService buildingBaseService;
    private final BuildingMapper buildingMapper;

    public UserServiceImpl(IAuthService authService, UserRepository userRepository, JwtTokenService jwtTokenService, UserMapper userMapper, ApartmentBaseService apartmentBaseService, ApartmentMapper apartmentMapper, BuildingBaseService buildingBaseService, BuildingMapper buildingMapper) {
        this.authService = authService;
        this.userRepository = userRepository;
        this.jwtTokenService = jwtTokenService;
        this.userMapper = userMapper;
        this.apartmentBaseService = apartmentBaseService;
        this.apartmentMapper = apartmentMapper;
        this.buildingBaseService = buildingBaseService;
        this.buildingMapper = buildingMapper;
    }

    @Transactional
    @Override
    public String createNewUser(DtoUserCreate dtoUserCreate) {
        User user = User.builder()
                .name(dtoUserCreate.getName())
                .phone(dtoUserCreate.getPhone())
                .build();

        Auth auth = authService.createNewAuth(dtoUserCreate.getEmail(), dtoUserCreate.getPassword(), userRepository.save(user));
        if (auth == null) {
            throw new ApplicationException(new ErrorMessage(MessageType.AUTH_CREATION_FAILED, "Failed to create user authentication"));
        }
        return "User created successfully.";
    }

    @Override
    public DtoUser getUserByTokenAndId(String token, Long id) {
        Auth auth = authService.getAuthByToken(token);
        // if auth is null, it means the token is invalid or expired
        if (auth == null) {
            throw new ApplicationException(new ErrorMessage(MessageType.INVALID_CREDENTIALS, "Invalid credentials"));
        }
        // if id is null, return the user associated with the auth
        if (id != null && !auth.getUser().getId().equals(id)) {
            return userMapper.toDtoUser(userRepository.getUserById(id).orElseThrow(() ->
                    new ApplicationException(new ErrorMessage(MessageType.USER_NOT_FOUND, "User not found with id: " + id))));
        }
        return userMapper.toDtoUser(auth.getUser());
    }

    @Override
    @Transactional
    public String updateUser(String token, DtoUserUpdate dtoUserUpdate) {
        User user = getUserByEmail(jwtTokenService.findEmailFromToken(token.replace("Bearer ", "")));
        if (!Objects.equals(user.getId(), dtoUserUpdate.getId())) {
            throw new ApplicationException(new ErrorMessage(MessageType.INVALID_CREDENTIALS, "Invalid credentials"));
        }
        if (dtoUserUpdate.getName() != null) {
            user.setName(dtoUserUpdate.getName());
        }
        if (dtoUserUpdate.getPhone() != null) {
            user.setPhone(dtoUserUpdate.getPhone());
        }
        userRepository.save(user);
        return "User records' updated successfully.";
    }

    @Override
    @Transactional
    public String deleteUser(String token) {
        User user = getUserByEmail(jwtTokenService.findEmailFromToken(token.replace("Bearer ", "")));
        if (user == null) {
            throw new ApplicationException(new ErrorMessage(MessageType.USER_NOT_FOUND, "User not found"));
        }
        userRepository.delete(user);
        if (!jwtTokenService.isTokenBlacklisted(token)) {
            jwtTokenService.blacklistToken(token);
        }
        return "User records' deleted successfully.";
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findAll().stream()
                .filter(user -> user.getAuth() != null && user.getAuth().getEmail().equals(email))
                .findFirst()
                .orElseThrow(() -> new ApplicationException(new ErrorMessage(MessageType.USER_NOT_FOUND, "User not found with email: " + email)));
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.getUserById(id).orElseThrow(() -> new ApplicationException(new ErrorMessage(MessageType.USER_NOT_FOUND, "User not found with id: " + id)));
    }

    @Override
    public void checkUserIsMemberOfBuilding(String email, Long buildingId) {
        if (isNotUserMemberOfBuildingOperation(getUserByEmail(email), buildingId))
            throw new ApplicationException(new ErrorMessage(MessageType.UNAUTHORIZED, "User is not a member of the building with id: " + buildingId));
    }

    private boolean isNotUserMemberOfBuildingOperation(User user, Long buildingId) {
        if (user == null || buildingId == null) {
            return true;
        }
        boolean isManagedBuilding = isNotManagerOfBuildingOperation(user, buildingId);
        boolean isOwnedOrTenantApartment = isNotOwnerOrTenantOfApartmentOperation(user, buildingId);
        return isManagedBuilding && isOwnedOrTenantApartment;
    }

    @Override
    public void checkUserIsManagerOfBuilding(User user, Long buildingId) {
        if (isNotManagerOfBuildingOperation(user, buildingId))
            throw new ApplicationException(new ErrorMessage(MessageType.UNAUTHORIZED, "User is not a manager of the building with id: " + buildingId));
    }

    @Override
    public void checkUserIsManagerOfBuilding(String email, Long buildingId) {
        if (isNotManagerOfBuildingOperation(getUserByEmail(email), buildingId))
            throw new ApplicationException(new ErrorMessage(MessageType.UNAUTHORIZED, "User is not a manager of the building with id: " + buildingId));
    }

    private boolean isNotManagerOfBuildingOperation(User user, Long buildingId) {
        if (user == null || buildingId == null || user.getManagedBuildings() == null) {
            return true;
        }
        User temp = userRepository.getUserWithManagedBuildingsById(user.getId());
        if (temp != null && temp.getManagedBuildings().stream().anyMatch(building -> buildingId.equals(building.getId())))
            return false;

        return true;
    }

    @Override
    public void checkUserIsOwnerOrTenantOfApartment(User user, Long apartmentId) {
        if (isNotOwnerOrTenantOfApartmentOperation(user, apartmentId))
            throw new ApplicationException(new ErrorMessage(MessageType.UNAUTHORIZED, "User is not the owner or tenant of the apartment with id: " + apartmentId));
    }

    @Override
    public void checkUserIsOwnerOrTenantOfApartment(String email, Long apartmentId) {
        if (isNotOwnerOrTenantOfApartmentOperation(getUserByEmail(email), apartmentId))
            throw new ApplicationException(new ErrorMessage(MessageType.UNAUTHORIZED, "User is not the owner or tenant of the apartment with id: " + apartmentId));
    }

    private boolean isNotOwnerOrTenantOfApartmentOperation(User user, Long apartmentId) {
        if (user == null || apartmentId == null) {
            return true;
        }
        User temp = userRepository.getUserWithApartmentsById(user.getId());

        if (user.getOwnedApartments() != null && user.getOwnedApartments().stream().anyMatch(apartment ->
                apartment != null && apartment.getBuilding() != null && apartment.getId().equals(apartmentId)))
            return false;

        else return temp.getRentedApartment() == null || !user.getRentedApartment().getId().equals(apartmentId);
    }

    @Override
    public void checkUserIsOwnerOfApartment(String email, Long apartmentId) {
        User user = getUserByEmail(email);
        if (user == null || user.getOwnedApartments() == null) {
            throw new ApplicationException(new ErrorMessage(MessageType.UNAUTHORIZED, "User is not the owner of the apartment with id: " + apartmentId));
        }
        if (user.getOwnedApartments().stream().noneMatch(apartment -> apartment != null && apartment.getId().equals(apartmentId)))
            throw new ApplicationException(new ErrorMessage(MessageType.UNAUTHORIZED, "User is not the owner of the apartment with id: " + apartmentId));
    }

    @Override
    public Page<DtoBuilding> getBuildingsByUser(String token, int page, int size, String sortBy, String sortDirection) {
        String email = jwtTokenService.findEmailFromToken(token.replace("Bearer ", ""));
        User user = getUserByEmail(email);
        return buildingBaseService
                .getBuildingsByUser(user.getId(), page, size, sortBy, sortDirection)
                .map(buildingMapper::toDtoBuilding);
    }

    @Override
    public Page<DtoApartment> getOwnerApartmentsByUser(String token, int page, int size, String sortBy, String sortDirection) {
        String email = jwtTokenService.findEmailFromToken(token.replace("Bearer ", ""));
        User user = getUserByEmail(email);

        return apartmentBaseService.getOwnerApartmentsByUserId(user.getId(), page, size, sortBy, sortDirection)
                .map(apartmentMapper::toDtoApartment);
    }

    @Override
    public DtoApartment getRentedApartmentByUser(String token) {
        String email = jwtTokenService.findEmailFromToken(token.replace("Bearer ", ""));
        User user = getUserByEmail(email);

        return apartmentMapper.toDtoApartment(apartmentBaseService.getRentedApartmentByUserId(user.getId()));
    }
}



================================================
FILE: src/main/java/com/seyitkoc/service/impl/VoteServiceImpl.java
================================================
package com.seyitkoc.service.impl;

import com.seyitkoc.service.IVoteService;
import com.seyitkoc.entity.Poll;
import com.seyitkoc.entity.User;
import com.seyitkoc.repository.PollRepository;
import com.seyitkoc.common.security.JwtTokenService;
import com.seyitkoc.service.IUserService;
import com.seyitkoc.entity.Vote;
import com.seyitkoc.repository.VoteRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VoteServiceImpl implements IVoteService {
    private final PollRepository pollRepository;
    private final VoteRepository voteRepository;
    private final JwtTokenService jwtTokenService;
    private final IUserService userService;

    public VoteServiceImpl(PollRepository pollRepository, VoteRepository voteRepository, JwtTokenService jwtTokenService, IUserService userService) {
        this.pollRepository = pollRepository;
        this.voteRepository = voteRepository;
        this.jwtTokenService = jwtTokenService;
        this.userService = userService;
    }

    @Override
    @Transactional
    public Vote castVote(String token, Long pollId, Long apartmentId, Long voteOptionId) {
        User user = userService.getUserByEmail(jwtTokenService.findEmailFromToken(token.replace("Bearer ", "")));

        Optional<Poll> pollOptional = pollRepository.findById(pollId);
        if (pollOptional.isEmpty() || !pollOptional.get().isActive()) {
            throw new IllegalArgumentException("Poll not found or is closed");
        }
        Poll poll = pollOptional.get();
        if(poll.getVotes().stream().anyMatch(vote -> vote.getVoterApartmentId().equals(apartmentId))){
            throw new IllegalArgumentException("Already voted for this apartment in this poll");
        }

        // Check if the apartment is in the building.

        Vote newVote = new Vote();
        newVote.setPoll(poll);
        newVote.setVotedAt(java.time.LocalDateTime.now());
        newVote.setVoterName(user.getName());
        newVote.setVoter(user);
        newVote.setVoterApartmentId(apartmentId);
        newVote.setPollOption(poll.getOptions().stream()
                .filter(option -> option.getId().equals(voteOptionId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Vote option not found")));
        return voteRepository.save(newVote);
    }


}



================================================
FILE: src/main/java/com/seyitkoc/specification/AnnouncementSpecification.java
================================================
package com.seyitkoc.specification;

import com.seyitkoc.entity.Announcement;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class AnnouncementSpecification {

    public Specification<Announcement> byBuildingId (Long buildingId) {
        return (root, query, criteriaBuilder) -> {
            if (buildingId == null) {
                return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
            }
            return criteriaBuilder.equal(root.get("building").get("id"), buildingId);
        };
    }

    public Specification<Announcement> byApartmentId(Long apartmentId) {
        return (root, query, criteriaBuilder) -> {
            if (apartmentId == null) {
                return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
            }
            return criteriaBuilder.equal(root.get("apartmentAnnouncements").get("apartment").get("id"), apartmentId);
        };
    }

    public Specification<Announcement> byIsRead(Boolean isRead) {
        return (root, query, criteriaBuilder) -> {
            if (isRead == null) {
                return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
            }
            return criteriaBuilder.equal(root.get("isRead"), isRead);
        };
    }

    public Specification<Announcement> byText(String text) {
        return (root, query, criteriaBuilder) -> {
            if (text == null || text.isEmpty()) {
                return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
            }
            return criteriaBuilder.or(
                    criteriaBuilder.like(criteriaBuilder.lower(root.get("title")), "%" + text.toLowerCase() + "%"),
                    criteriaBuilder.like(criteriaBuilder.lower(root.get("content")), "%" + text.toLowerCase() + "%")
            );
        };
    }

    public Specification<Announcement> byMinCreatedAt(LocalDateTime minCreatedAt) {
        return (root, query, criteriaBuilder) -> {
            if (minCreatedAt == null) {
                return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
            }
            return criteriaBuilder.greaterThanOrEqualTo(root.get("createdAt"), minCreatedAt);
        };
    }
    public Specification<Announcement> byMaxCreatedAt(LocalDateTime maxCreatedAt) {
        return (root, query, criteriaBuilder) -> {
            if (maxCreatedAt == null) {
                return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
            }
            return criteriaBuilder.lessThanOrEqualTo(root.get("createdAt"), maxCreatedAt);
        };
    }

    public Specification<Announcement> byCreatedBy(String createdBy) {
        return (root, query, criteriaBuilder) -> {
            if (createdBy == null || createdBy.isEmpty()) {
                return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
            }
            return criteriaBuilder.equal(criteriaBuilder.lower(root.get("createdBy")), createdBy.toLowerCase());
        };
    }


}



================================================
FILE: src/main/java/com/seyitkoc/specification/ApartmentDebtsSpecification.java
================================================
package com.seyitkoc.specification;

import com.seyitkoc.entity.ApartmentDebts;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class ApartmentDebtsSpecification {

    public Specification<ApartmentDebts> byApartmentAccountId(Long accountId) {
        return ((root, query, criteriaBuilder) -> {
            if (accountId == null)
                return criteriaBuilder.isTrue(criteriaBuilder.literal(true));

            return criteriaBuilder.equal(root.get("apartmentAccount").get("id"), accountId);
        });
    }

    public Specification<ApartmentDebts> byDebtId(Long debtId) {
        return ((root, query, criteriaBuilder) -> {
            if (debtId == null)
                return criteriaBuilder.isTrue(criteriaBuilder.literal(true));

            return criteriaBuilder.equal(root.get("debt").get("id"), debtId);
        });
    }

    public Specification<ApartmentDebts> byPaid(Boolean isPaid) {
        return ((root, query, criteriaBuilder) -> {
            if (isPaid == null)
                return criteriaBuilder.isTrue(criteriaBuilder.literal(true));

            return criteriaBuilder.equal(root.get("paid"), isPaid);
        });
    }

    public Specification<ApartmentDebts> byConfirmed(Boolean isConfirmed) {
        return ((root, query, criteriaBuilder) -> {
            if (isConfirmed == null)
                return criteriaBuilder.isTrue(criteriaBuilder.literal(true));

            return criteriaBuilder.equal(root.get("confirmed"), isConfirmed);
        });
    }



}



================================================
FILE: src/main/java/com/seyitkoc/specification/BuildingAccountSpecification.java
================================================
package com.seyitkoc.specification;

import com.seyitkoc.entity.BuildingAccount;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class BuildingAccountSpecification {

    public Specification<BuildingAccount> byBuildingId (Long buildingId) {
        return (root, query, criteriaBuilder) -> {
            if (buildingId == null) {
                return criteriaBuilder.isTrue(criteriaBuilder.literal(true)); // No filter applied
            }
            return criteriaBuilder.equal(root.get("building").get("id"), buildingId);
        };
    }

    public Specification<BuildingAccount> byYear(Integer year) {
        return (root, query, criteriaBuilder) -> {
            if (year == null) {
                return criteriaBuilder.isTrue(criteriaBuilder.literal(true)); // No filter applied
            }
            return criteriaBuilder.equal(criteriaBuilder.function("YEAR", Integer.class, root.get("createdAt")), year);
        };
    }

}



================================================
FILE: src/main/java/com/seyitkoc/specification/DebtSpecification.java
================================================
package com.seyitkoc.specification;

import com.seyitkoc.entity.Debt;
import com.seyitkoc.enums.DebtType;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DebtSpecification {

    public Specification<Debt> hasBuildingId(Long buildingId) {
        return ((root, query, criteriaBuilder) -> {
            if (buildingId == null) {
                return criteriaBuilder.conjunction(); // always true, yani bu filter yokmuş gibi davran
            }
            return criteriaBuilder.equal(root.get("buildingId"), buildingId);
        });
    }

    public Specification<Debt> hasApartmentId(Long apartmentId) {
        return ((root, query, criteriaBuilder) -> {
            if (apartmentId == null) {
                return criteriaBuilder.conjunction(); // always true, yani bu filter yokmuş gibi davran
            }
            return criteriaBuilder.equal(root.get("apartmentDebts").get("apartmentAccount").get("apartment").get("id"), apartmentId);
        });
    }

    public Specification<Debt> hasType(String type) {
        return (root, query, criteriaBuilder) -> {
            if (type == null || type.isBlank()) {
                return criteriaBuilder.conjunction(); // always true, yani bu filter yokmuş gibi davran
            }
            return criteriaBuilder.equal(root.get("type"), DebtType.valueOf(type));
        };
    }

    public Specification<Debt> descriptionHasText(String text) {
        return ((root, query, criteriaBuilder) -> {
            if (text == null || text.isBlank()) {
                return criteriaBuilder.conjunction(); // always true, yani bu filter yokmuş gibi davran
            }
            return criteriaBuilder.like(criteriaBuilder.lower(root.get("description")), "%" + text.toLowerCase() + "%");
        });
    }

    public Specification<Debt> hasMinAmount(Double minAmount) {
        return ((root, query, criteriaBuilder) -> {
            if (minAmount == null) {
                return criteriaBuilder.conjunction(); // always true, yani bu filter yokmuş gibi davran
            }
            return criteriaBuilder.greaterThanOrEqualTo(root.get("amount"), minAmount);
        });
    }

    public Specification<Debt> hasMaxAmount(Double maxAmount) {
        return ((root, query, criteriaBuilder) -> {
            if (maxAmount == null) {
                return criteriaBuilder.conjunction(); // always true, yani bu filter yokmuş gibi davran
            }
            return criteriaBuilder.lessThanOrEqualTo(root.get("amount"), maxAmount);
        });
    }

    public Specification<Debt> hasMinCreatedAt(LocalDateTime minCreatedAt) {
        return ((root, query, criteriaBuilder) -> {
            if (minCreatedAt == null) {
                return criteriaBuilder.conjunction(); // always true, yani bu filter yokmuş gibi davran
            }
            return criteriaBuilder.greaterThanOrEqualTo(root.get("createdAt"), minCreatedAt);
        });
    }

    public Specification<Debt> hasMaxCreatedAt(LocalDateTime maxCreatedAt) {
        return ((root, query, criteriaBuilder) -> {
            if (maxCreatedAt == null) {
                return criteriaBuilder.conjunction(); // always true, yani bu filter yokmuş gibi davran
            }
            return criteriaBuilder.lessThanOrEqualTo(root.get("createdAt"), maxCreatedAt);
        });
    }
}



================================================
FILE: src/main/java/com/seyitkoc/specification/PollSpecification.java
================================================
package com.seyitkoc.specification;

import com.seyitkoc.entity.Poll;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PollSpecification {

    public Specification<Poll> byBuildingId(Long buildingId) {
        return ((root, query, criteriaBuilder) -> {
            if (buildingId == null)
                return criteriaBuilder.isTrue(criteriaBuilder.literal(true));

            return criteriaBuilder.equal(root.get("building").get("id"), buildingId);
        });
    }

    public Specification<Poll> byText(String text) {
        return ((root, query, criteriaBuilder) -> {
            if (text == null || text.isEmpty())
                return criteriaBuilder.isTrue(criteriaBuilder.literal(true));

            return criteriaBuilder.or(
                    criteriaBuilder.like(criteriaBuilder.lower(root.get("title")), "%" + text.toLowerCase() + "%"),
                    criteriaBuilder.like(criteriaBuilder.lower(root.get("description")), "%" + text.toLowerCase() + "%"));
        });
    }

    public Specification<Poll> byMinCreateAt(LocalDateTime minCreateAt) {
        return ((root, query, criteriaBuilder) -> {
            if (minCreateAt == null)
                return criteriaBuilder.isTrue(criteriaBuilder.literal(true));

            return criteriaBuilder.greaterThanOrEqualTo(root.get("createdAt"), minCreateAt);
        });
    }

    public Specification<Poll> byMaxCreateAt(LocalDateTime maxCreateAt) {
        return ((root, query, criteriaBuilder) -> {
            if (maxCreateAt == null)
                return criteriaBuilder.isTrue(criteriaBuilder.literal(true));

            return criteriaBuilder.lessThanOrEqualTo(root.get("createdAt"), maxCreateAt);
        });
    }

    public Specification<Poll> byIsFinished(Boolean isFinished) {
        return ((root, query, criteriaBuilder) -> {
            if (isFinished == null)
                return criteriaBuilder.isTrue(criteriaBuilder.literal(true));

            if (isFinished)
                return criteriaBuilder.lessThanOrEqualTo(root.get("finishDate"), LocalDateTime.now());

            return criteriaBuilder.greaterThanOrEqualTo(root.get("finishDate"), LocalDateTime.now());
        });
    }
}



================================================
FILE: src/main/java/com/seyitkoc/specification/TransactionSpecification.java
================================================
package com.seyitkoc.specification;

import com.seyitkoc.entity.transaction.Transaction;
import com.seyitkoc.enums.ExpenseType;
import com.seyitkoc.enums.IncomeType;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class TransactionSpecification {

    public Specification<Transaction> byType(String type) {
        return ((root, query, criteriaBuilder) -> {
            if (type == null)
                return criteriaBuilder.conjunction();

            return criteriaBuilder.equal(root.get("type"), type.toUpperCase());
        });
    }

    public Specification<Transaction> bySubType(String type,String subType) {
        return ((root, query, criteriaBuilder) -> {
            if (subType == null || type == null)
                return criteriaBuilder.conjunction();

            if (type.equalsIgnoreCase("income"))
                return criteriaBuilder.equal(root.get("subType"), IncomeType.valueOf(type.toUpperCase()));

            if (type.equalsIgnoreCase("expense"))
                return  criteriaBuilder.equal(root.get("subType"), ExpenseType.valueOf(type.toUpperCase()));

            return  criteriaBuilder.conjunction();
        });
    }

    public Specification<Transaction> hasBuildingAccountId(Long buildingAccountId) {
        return ((root, query, criteriaBuilder) -> {
            if (buildingAccountId == null) {
                return criteriaBuilder.conjunction(); // always true, yani bu filter yokmuş gibi davran
            }
            return criteriaBuilder.equal(root.get("buildingAccount").get("id"), buildingAccountId);
        });
    }

    public Specification<Transaction> hasBuildingId(Long buildingId) {
        return ((root, query, criteriaBuilder) -> {
            if (buildingId == null) {
                return criteriaBuilder.conjunction(); // always true, yani bu filter yokmuş gibi davran
            }
            return criteriaBuilder.equal(root.get("buildingAccount").get("building").get("id"), buildingId);
        });
    }

    public Specification<Transaction> hasMinAmount(Double minAmount) {
        return ((root, query, criteriaBuilder) -> {
            if (minAmount == null) {
                return criteriaBuilder.conjunction(); // always true, yani bu filter yokmuş gibi davran
            }
            return criteriaBuilder.greaterThanOrEqualTo(root.get("amount"), minAmount);
        });
    }

    public Specification<Transaction> hasMaxAmount(Double maxAmount) {
        return ((root, query, criteriaBuilder) -> {
            if (maxAmount == null) {
                return criteriaBuilder.conjunction(); // always true, yani bu filter yokmuş gibi davran
            }
            return criteriaBuilder.lessThanOrEqualTo(root.get("amount"), maxAmount);
        });
    }

    public Specification<Transaction> descriptionHasText(String text) {
        return ((root, query, criteriaBuilder) -> {
            if (text == null || text.isBlank()) {
                return criteriaBuilder.conjunction(); // always true, yani bu filter yokmuş gibi davran
            }
            return criteriaBuilder.like(criteriaBuilder.lower(root.get("description")), "%" + text.toLowerCase() + "%");
        });
    }

    public Specification<Transaction> hasStartDate(String startDate) {
        return ((root, query, criteriaBuilder) -> {
            if (startDate == null || startDate.isBlank()) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.greaterThanOrEqualTo(root.get("transactionDate"), startDate); // "date" yerine "transactionDate"
        });
    }

    public Specification<Transaction> hasEndDate(String endDate) {
        return ((root, query, criteriaBuilder) -> {
            if (endDate == null || endDate.isBlank()) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.lessThanOrEqualTo(root.get("transactionDate"), endDate); // "date" yerine "transactionDate"
        });
    }
}



================================================
FILE: src/main/resources/application.properties
================================================
spring.application.name=ams

server.port=8443
server.ssl.key-store=classpath:keystore.p12
server.ssl.key-store-password=springproject
server.ssl.key-store-type=PKCS12
server.ssl.key-alias=mysslkey


spring.datasource.url=jdbc:mysql://localhost:3306/new-db
spring.datasource.username=springstudent
spring.datasource.password=springstudent

spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update

logging.level.org.springframework.security=DEBUG



================================================
FILE: src/main/resources/keystore.p12
================================================
[Non-text file]


================================================
FILE: src/main/resources/META-INF/MANIFEST.MF
================================================
Manifest-Version: 1.0
Main-Class: com.seyitkoc.AmsApplication




================================================
FILE: src/test/java/com/seyitkoc/service/impl/AnnouncementServiceImplTest.java
================================================
package com.seyitkoc.service.impl;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.*;

import com.seyitkoc.dto.announcement.DtoAnnouncement;
import com.seyitkoc.dto.announcement.DtoAnnouncementIU;
import com.seyitkoc.entity.Announcement;
import com.seyitkoc.entity.Apartment;
import com.seyitkoc.entity.Building;
import com.seyitkoc.common.exception.ApplicationException;
import com.seyitkoc.common.exception.ErrorMessage;
import com.seyitkoc.common.exception.MessageType;
import com.seyitkoc.mapper.AnnouncementMapper;
import com.seyitkoc.repository.AnnouncementRepository;
import com.seyitkoc.common.security.JwtTokenService;
import com.seyitkoc.service.IApartmentAnnouncementService;
import com.seyitkoc.service.IApartmentService;
import com.seyitkoc.service.IBuildingService;
import com.seyitkoc.service.IUserService;
import com.seyitkoc.specification.AnnouncementSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

class AnnouncementServiceImplTest {
    private AnnouncementServiceImpl announcementService;

    private AnnouncementMapper announcementMapper;
    private AnnouncementRepository announcementRepository;
    private IBuildingService buildingService;
    private IApartmentService apartmentService;
    private IApartmentAnnouncementService apartmentAnnouncementService;
    private IUserService userService;
    private JwtTokenService jwtTokenService;
    private AnnouncementSpecification announcementSpecification;

    String token = "testToken";
    String email = "test@test.com";
    Announcement announcement;
    DtoAnnouncementIU dtoAnnouncementIU;
    DtoAnnouncement dtoAnnouncement;
    Building building;
    List<Apartment> apartments;

    @BeforeEach
    void setUp() {
        announcementMapper = mock(AnnouncementMapper.class);
        announcementRepository = mock(AnnouncementRepository.class);
        buildingService = mock(IBuildingService.class);
        apartmentService = mock(IApartmentService.class);
        apartmentAnnouncementService = mock(IApartmentAnnouncementService.class);
        userService = mock(IUserService.class);
        jwtTokenService = mock(JwtTokenService.class);
        announcementSpecification = mock(AnnouncementSpecification.class);

        announcementService = new AnnouncementServiceImpl(announcementMapper, announcementRepository, buildingService, apartmentService, apartmentAnnouncementService, userService, jwtTokenService);

        dtoAnnouncementIU = DtoAnnouncementIU.builder()
                .title("Test Announcement")
                .content("This is a test announcement.")
                .createdBy("testUser")
                .buildingId(1L)
                .apartmentIds(List.of(1L, 2L))
                .build();

        dtoAnnouncement = DtoAnnouncement.builder()
                .id(1L)
                .title("Test Announcement")
                .content("This is a test announcement.")
                .createdBy("testUser")
                .buildingId(1L)
                .apartmentIds(List.of(1L, 2L))
                .build();

        building = Building.builder()
                .id(1L)
                .name("Test Building")
                .build();


        announcement = Announcement.builder()
                .id(1L)
                .title("Test Announcement")
                .content("This is a test announcement.")
                .createdBy("testUser")
                .building(building)
                .apartmentAnnouncements(new ArrayList<>())
                .build();

        apartments = List.of(
                Apartment.builder().id(1L).building(building).build(),
                Apartment.builder().id(2L).building(building).build()
        );

    }

    // Test for createAnnouncement method with parameters
    @Test
    public void whenCreateAnnouncementCalledWithParams_thenAnnouncementIsCreated() {
        // Arrange
        String title = "Test Announcement";
        String content = "This is a test announcement.";
        String createdBy = "testUser";
        Long buildingId = 1L;
        List<Long> apartmentIds = List.of(1L, 2L);

        when(buildingService.getBuildingById(1L)).thenReturn(building);

        when(announcementMapper.createAnnouncement(any(DtoAnnouncementIU.class), eq(building))).thenReturn(announcement);
        when(announcementRepository.save(any(Announcement.class))).thenReturn(announcement);


        when(apartmentService.getApartmentById(1L)).thenReturn(apartments.getFirst());
        when(apartmentService.getApartmentById(2L)).thenReturn(apartments.getLast());

        //ACT
        announcementService.createAnnouncement(title, content, createdBy, buildingId, apartmentIds);

        // ASSERT
        verify(buildingService).getBuildingById(1L);
        verify(announcementMapper).createAnnouncement(any(DtoAnnouncementIU.class), eq(building));

        verify(announcementRepository).save(any(Announcement.class));

        verify(apartmentService).getApartmentById(1L);
        verify(apartmentService).getApartmentById(2L);

        verify(apartmentAnnouncementService).createApartmentAnnouncement(announcement, apartments.getFirst());
        verify(apartmentAnnouncementService).createApartmentAnnouncement(announcement, apartments.getLast());
    }
    @Test
    public void whenCreateAnnouncementCalledWithParams_thenBuildingNotFoundExceptionIsThrown() {
        String title = "Test Announcement";
        String content = "This is a test announcement.";
        String createdBy = "testUser";
        Long buildingId = 1L;
        List<Long> apartmentIds = List.of(1L, 2L);

        when(buildingService.getBuildingById(buildingId))
                .thenThrow(new IllegalArgumentException("Building not found"));

        assertThrows(IllegalArgumentException.class, () -> {
            announcementService.createAnnouncement(title, content, createdBy, buildingId, apartmentIds);
        });

        verify(buildingService).getBuildingById(buildingId);
        verifyNoInteractions(announcementMapper, announcementRepository, apartmentService, apartmentAnnouncementService);
    }
    @Test
    public void whenCreateAnnouncementCalledWithParams_thenApartmentNotFoundExceptionIsThrown() {
        String title = "Test Announcement";
        String content = "This is a test announcement.";
        String createdBy = "testUser";
        Long buildingId = 1L;
        List<Long> apartmentIds = List.of(10L, 20L);

        when(buildingService.getBuildingById(buildingId)).thenReturn(building);

        when(announcementMapper.createAnnouncement(any(DtoAnnouncementIU.class), eq(building)))
                .thenReturn(announcement);

        when(announcementRepository.save(any(Announcement.class))).thenReturn(announcement);

        when(apartmentService.getApartmentById(10L)).thenReturn(apartments.getFirst());

        when(apartmentService.getApartmentById(20L))
                .thenThrow(new ApplicationException(new ErrorMessage(MessageType.NOT_FOUND, "Apartment not found with id: 20")));

        assertThrows(ApplicationException.class, () -> {
            announcementService.createAnnouncement(title, content, createdBy, buildingId, apartmentIds);
        });

        verify(buildingService).getBuildingById(buildingId);
        verify(apartmentService).getApartmentById(10L);
        verify(apartmentService).getApartmentById(20L);
        verify(apartmentAnnouncementService).createApartmentAnnouncement(announcement, apartments.getFirst());
        verify(apartmentAnnouncementService, times(1)).createApartmentAnnouncement(any(), any());
    }

    // Test for createAnnouncement method with DtoAnnouncementIU
    @Test
    public void whenCreateAnnouncementCalledWithDto_thenAnnouncementIsCreated() {
        DtoAnnouncement expectedDto = DtoAnnouncement.builder()
                .id(1L)
                .build();

        when(jwtTokenService.findEmailFromToken(token)).thenReturn(email);
        doNothing().when(userService).checkUserIsManagerOfBuilding(email, 1L);

        when(buildingService.getBuildingById(1L)).thenReturn(building);

        when(announcementMapper.createAnnouncement(any(DtoAnnouncementIU.class), eq(building))).thenReturn(announcement);
        when(announcementRepository.save(any(Announcement.class))).thenReturn(announcement);

        when(apartmentService.getApartmentById(1L)).thenReturn(apartments.getFirst());
        when(apartmentService.getApartmentById(2L)).thenReturn(apartments.getLast());

        when(announcementMapper.toDtoAnnouncement(announcement)).thenReturn(expectedDto);

        // ACT
        DtoAnnouncement result = announcementService.createAnnouncement(dtoAnnouncementIU, token);

        // ASSERT
        verify(jwtTokenService).findEmailFromToken(token);
        verify(userService).checkUserIsManagerOfBuilding(email, 1L);
        verify(buildingService).getBuildingById(1L);

        verify(announcementMapper).createAnnouncement(any(DtoAnnouncementIU.class), eq(building));
        verify(announcementRepository).save(any(Announcement.class));

        verify(apartmentService).getApartmentById(1L);
        verify(apartmentService).getApartmentById(2L);

        verify(apartmentAnnouncementService).createApartmentAnnouncement(announcement, apartments.getFirst());
        verify(apartmentAnnouncementService).createApartmentAnnouncement(announcement, apartments.getLast());

        assert result != null;
        assert result.getId().equals(expectedDto.getId());
    }
    @Test
    public void whenCreateAnnouncementCalledWithDto_thenUserIsNotManagerOfBuildingIsThrown() {
        when(jwtTokenService.findEmailFromToken(token)).thenReturn(email);
        doThrow(new ApplicationException(new ErrorMessage(MessageType.UNAUTHORIZED, "User is not a manager of the building with id: 1")))
                .when(userService).checkUserIsManagerOfBuilding(email, 1L);

        assertThrows(ApplicationException.class, () -> {
            announcementService.createAnnouncement(dtoAnnouncementIU, token);
        });

        verify(userService).checkUserIsManagerOfBuilding(email, 1L);
        verifyNoInteractions(buildingService, announcementMapper, announcementRepository, apartmentService, apartmentAnnouncementService);
    }
    @Test
    public void whenCreateAnnouncementCalledWithDto_thenBuildingNotFoundExceptionIsThrown() {
        when(jwtTokenService.findEmailFromToken(token)).thenReturn(email);
        doNothing().when(userService).checkUserIsManagerOfBuilding(email, 1L);

        when(buildingService.getBuildingById(1L))
                .thenThrow(new IllegalArgumentException("Building not found"));

        assertThrows(IllegalArgumentException.class, () -> {
            announcementService.createAnnouncement(dtoAnnouncementIU, token);
        });

        verify(buildingService).getBuildingById(dtoAnnouncementIU.getBuildingId());
        verifyNoInteractions(announcementMapper, announcementRepository, apartmentService, apartmentAnnouncementService);
    }
    @Test
    void whenCreateAnnouncementCalledWithDto_thenApartmentNotFoundExceptionIsThrown() {
        when(jwtTokenService.findEmailFromToken(token)).thenReturn(email);
        doNothing().when(userService).checkUserIsManagerOfBuilding(email, 1L);

        when(buildingService.getBuildingById(1L)).thenReturn(building);

        when(announcementMapper.createAnnouncement(any(DtoAnnouncementIU.class), eq(building)))
                .thenReturn(announcement);

        when(announcementRepository.save(any(Announcement.class))).thenReturn(announcement);

        when(apartmentService.getApartmentById(1L)).thenReturn(apartments.getFirst());

        when(apartmentService.getApartmentById(2L))
                .thenThrow(new ApplicationException(new ErrorMessage(MessageType.NOT_FOUND, "Apartment not found with id: 2")));

        assertThrows(ApplicationException.class, () -> {
            announcementService.createAnnouncement(dtoAnnouncementIU, token);
        });

        verify(buildingService).getBuildingById(dtoAnnouncementIU.getBuildingId());
        verify(apartmentService).getApartmentById(1L);
        verify(apartmentService).getApartmentById(2L);
        verify(apartmentAnnouncementService).createApartmentAnnouncement(announcement, apartments.getFirst());
        verify(apartmentAnnouncementService, times(1)).createApartmentAnnouncement(any(), any());
    }

    // Test for getAnnouncements method
    @Test
    public void whenGetAnnouncements_thenReturnListOfDtoAnnouncements() {
        Page<Announcement> announcementPage = new PageImpl<>(List.of(announcement));

        when(jwtTokenService.findEmailFromToken(token))
                .thenReturn(email);
        doNothing().when(userService)
                .checkUserIsMemberOfBuilding(email, building.getId());

        when(announcementRepository.findAll(any(Specification.class), any(Pageable.class)))
                .thenReturn(announcementPage);


        when(announcementMapper.toDtoAnnouncement(announcement))
                .thenReturn(dtoAnnouncement);

        // Act
        /*Page<DtoAnnouncement> result = announcementService.getAnnouncements(
                token, building.getId(), "test", LocalDateTime.now(), LocalDateTime.now(), "system", 1, 10, "id", "asc"
        );*/

        // Assert

        verify(jwtTokenService).findEmailFromToken(token);
        verify(userService).checkUserIsMemberOfBuilding(email, building.getId());
        verify(announcementRepository).findAll(any(Specification.class), any(Pageable.class));
        verify(announcementMapper).toDtoAnnouncement(announcement);
    }
    /*
    @Test
    public void whenGetAnnouncements_thenUserIsNotMemberOfBuildingIsThrown() {
        when(jwtTokenService.findEmailFromToken(token)).thenReturn(email);
        doThrow(new ApplicationException(new ErrorMessage(MessageType.UNAUTHORIZED, "User is not a member of the building with id: 1")))
                .when(userService).checkUserIsMemberOfBuilding(email, 1L);

        assertThrows(ApplicationException.class, () -> {
            announcementService.getAnnouncements(token, 1L, "test", LocalDateTime.now(), LocalDateTime.now(), "system", 1, 10, "id", "asc");
        });

        verify(userService).checkUserIsMemberOfBuilding(email, 1L);
        verifyNoInteractions(announcementRepository, announcementMapper);
    }
    @Test
    public void whenGetAnnouncements_thenBuildingNotFoundExceptionIsThrown() {
        when(jwtTokenService.findEmailFromToken(token)).thenReturn(email);
        doNothing().when(userService).checkUserIsMemberOfBuilding(email, 1L);

        when(announcementRepository.findAll(any(Specification.class), any(Pageable.class)))
                .thenThrow(new IllegalArgumentException("Building not found"));

        assertThrows(IllegalArgumentException.class, () -> {
            announcementService.getAnnouncements(token, 1L, "test", LocalDateTime.now(), LocalDateTime.now(), "system", 1, 10, "id", "asc");
        });

        verify(announcementRepository).findAll(any(Specification.class), any(Pageable.class));
        verifyNoInteractions(announcementMapper);
    }
*/
    // Test for getAnnouncementById method
    @Test
    public void whenGetAnnouncementById_thenReturnDtoAnnouncement() {
        when(announcementRepository.findById(1L)).thenReturn(java.util.Optional.of(announcement));
        when(jwtTokenService.findEmailFromToken(token)).thenReturn(email);
        doNothing().when(userService).checkUserIsMemberOfBuilding(email, announcement.getBuilding().getId());
        when(announcementMapper.toDtoAnnouncement(announcement)).thenReturn(dtoAnnouncement);

        DtoAnnouncement result = announcementService.getAnnouncementById(1L, 1L, 1L, token);

        verify(announcementRepository).findById(1L);
        verify(jwtTokenService).findEmailFromToken(token);
        verify(userService).checkUserIsMemberOfBuilding(email, announcement.getBuilding().getId());
        verify(announcementMapper).toDtoAnnouncement(announcement);

        assert result != null;
        assert result.getId().equals(dtoAnnouncement.getId());
    }
    @Test
    public void whenGetAnnouncementById_thenAnnouncementNotFoundExceptionIsThrown() {
        when(announcementRepository.findById(1L)).thenReturn(java.util.Optional.empty());

        assertThrows(RuntimeException.class, () -> {
            announcementService.getAnnouncementById(1L, 1L, 1L, token);
        });

        verify(announcementRepository).findById(1L);
        verifyNoInteractions(jwtTokenService, userService, announcementMapper);
    }
    @Test
    public void whenGetAnnouncementById_thenUserIsNotMemberOfBuildingIsThrown() {
        when(announcementRepository.findById(1L)).thenReturn(java.util.Optional.of(announcement));
        when(jwtTokenService.findEmailFromToken(token)).thenReturn(email);
        doThrow(new ApplicationException(new ErrorMessage(MessageType.UNAUTHORIZED, "User is not a member of the building with id: 1")))
                .when(userService).checkUserIsMemberOfBuilding(email, announcement.getBuilding().getId());

        assertThrows(ApplicationException.class, () -> {
            announcementService.getAnnouncementById(1L, 1L, 1L, token);
        });

        verify(announcementRepository).findById(1L);
        verify(userService).checkUserIsMemberOfBuilding(email, announcement.getBuilding().getId());
        verifyNoInteractions(announcementMapper);
    }

    // Test for updateAnnouncement method
    @Test
    public void whenUpdateAnnouncement_thenReturnUpdatedDtoAnnouncement() {
        when(announcementRepository.findById(1L)).thenReturn(java.util.Optional.of(announcement));
        when(jwtTokenService.findEmailFromToken(token)).thenReturn(email);
        doNothing().when(userService).checkUserIsManagerOfBuilding(email, announcement.getBuilding().getId());

        doNothing().when(apartmentAnnouncementService).updateApartmentAnnouncement(announcement, dtoAnnouncementIU.getApartmentIds());
        when(announcementRepository.save(announcement)).thenReturn(announcement);
        when(announcementMapper.toDtoAnnouncement(announcement)).thenReturn(dtoAnnouncement);

        DtoAnnouncement result = announcementService.updateAnnouncement(1L, dtoAnnouncementIU, token);

        verify(announcementRepository).findById(1L);
        verify(jwtTokenService).findEmailFromToken(token);
        verify(userService).checkUserIsManagerOfBuilding(email, announcement.getBuilding().getId());
        verify(apartmentAnnouncementService).updateApartmentAnnouncement(announcement, dtoAnnouncementIU.getApartmentIds());
        verify(announcementRepository).save(announcement);
        verify(announcementMapper).toDtoAnnouncement(announcement);

        assert result != null;
        assert result.getId().equals(dtoAnnouncement.getId());
    }
    @Test
    public void whenUpdateAnnouncement_thenAnnouncementNotFoundExceptionIsThrown() {
        when(announcementRepository.findById(1L)).thenReturn(java.util.Optional.empty());

        assertThrows(RuntimeException.class, () -> {
            announcementService.updateAnnouncement(1L, dtoAnnouncementIU, token);
        });

        verify(announcementRepository).findById(1L);
        verifyNoInteractions(jwtTokenService, userService, apartmentAnnouncementService, announcementMapper);
    }
    @Test
    public void whenUpdateAnnouncement_thenUserIsNotManagerOfBuildingIsThrown() {
        when(announcementRepository.findById(1L)).thenReturn(java.util.Optional.of(announcement));
        when(jwtTokenService.findEmailFromToken(token)).thenReturn(email);
        doThrow(new ApplicationException(new ErrorMessage(MessageType.UNAUTHORIZED, "User is not a manager of the building with id: 1")))
                .when(userService).checkUserIsManagerOfBuilding(email, announcement.getBuilding().getId());

        assertThrows(ApplicationException.class, () -> {
            announcementService.updateAnnouncement(1L, dtoAnnouncementIU, token);
        });

        verify(announcementRepository).findById(1L);
        verify(userService).checkUserIsManagerOfBuilding(email, announcement.getBuilding().getId());
        verifyNoInteractions(apartmentAnnouncementService, announcementMapper);
    }

    // Test for deleteAnnouncement method
    @Test
    public void whenDeleteAnnouncement_thenAnnouncementIsDeleted() {
        when(announcementRepository.findById(1L)).thenReturn(java.util.Optional.of(announcement));
        when(jwtTokenService.findEmailFromToken(token)).thenReturn(email);
        doNothing().when(userService).checkUserIsManagerOfBuilding(email, announcement.getBuilding().getId());

        announcementService.deleteAnnouncement(1L, token);

        verify(announcementRepository).findById(1L);
        verify(jwtTokenService).findEmailFromToken(token);
        verify(userService).checkUserIsManagerOfBuilding(email, announcement.getBuilding().getId());
        verify(announcementRepository).delete(announcement);
    }
    @Test
    public void whenDeleteAnnouncement_thenAnnouncementNotFoundExceptionIsThrown() {
        when(announcementRepository.findById(1L)).thenReturn(java.util.Optional.empty());

        assertThrows(RuntimeException.class, () -> {
            announcementService.deleteAnnouncement(1L, token);
        });

        verify(announcementRepository).findById(1L);
        verifyNoInteractions(jwtTokenService, userService);
    }
    @Test
    public void whenDeleteAnnouncement_thenUserIsNotManagerOfBuildingIsThrown() {
        when(announcementRepository.findById(1L)).thenReturn(java.util.Optional.of(announcement));
        when(jwtTokenService.findEmailFromToken(token)).thenReturn(email);
        doThrow(new ApplicationException(new ErrorMessage(MessageType.UNAUTHORIZED, "User is not a manager of the building with id: 1")))
                .when(userService).checkUserIsManagerOfBuilding(email, announcement.getBuilding().getId());

        assertThrows(ApplicationException.class, () -> {
            announcementService.deleteAnnouncement(1L, token);
        });

        verify(announcementRepository).findById(1L);
        verify(userService).checkUserIsManagerOfBuilding(email, announcement.getBuilding().getId());
    }
}


================================================
FILE: src/test/java/com/seyitkoc/starter/AmsApplicationTests.java
================================================
package com.seyitkoc.starter;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AmsApplicationTests {

    @Test
    void contextLoads() {
    }

}



================================================
FILE: .mvn/wrapper/maven-wrapper.properties
================================================
# Licensed to the Apache Software Foundation (ASF) under one
# or more contributor license agreements.  See the NOTICE file
# distributed with this work for additional information
# regarding copyright ownership.  The ASF licenses this file
# to you under the Apache License, Version 2.0 (the
# "License"); you may not use this file except in compliance
# with the License.  You may obtain a copy of the License at
#
#   http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing,
# software distributed under the License is distributed on an
# "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
# KIND, either express or implied.  See the License for the
# specific language governing permissions and limitations
# under the License.
wrapperVersion=3.3.2
distributionType=only-script
distributionUrl=https://repo.maven.apache.org/maven2/org/apache/maven/apache-maven/3.9.9/apache-maven-3.9.9-bin.zip

