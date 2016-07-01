--<ScriptOptions statementTerminator=";"/>

CREATE TABLE Amenities (
	Id INT NOT NULL,
	Name VARCHAR(1024) NOT NULL,
	Description LONGTEXT,
	PRIMARY KEY (Id)
) ENGINE=InnoDB;

CREATE TABLE Applications (
	Id INT NOT NULL,
	ApartmentId INT,
	Status INT,
	ApplicationNumber CHAR(12) DEFAULT 000000000000,
	ApplyingDate DATE,
	ApplicantId INT NOT NULL,
	MoveInDate DATE,
	LeaseTerm INT,
	Cost DECIMAL(10 , 2),
	Notes LONGTEXT,
	AgentId INT,
	PRIMARY KEY (Id)
) ENGINE=InnoDB;

CREATE TABLE Apartments (
	Id INT NOT NULL,
	Landlord VARCHAR(1024),
	AptNumber VARCHAR(10),
	AptType VARCHAR(10),
	Address MEDIUMTEXT,
	City VARCHAR(1024),
	State VARCHAR(20),
	Area VARCHAR(10),
	Bathrooms VARCHAR(2),
	PricePerMonth DECIMAL(10 , 2),
	ApplicationFee DECIMAL(10 , 2),
	DamageDeposit DECIMAL(10 , 2),
	Description LONGTEXT,
	Availability BIT,
	AvailableDate DATE,
	AgentId INT,
	PRIMARY KEY (Id)
) ENGINE=InnoDB;

CREATE TABLE Reviews (
	Id INT NOT NULL,
	ReviewerName VARCHAR(255),
	ReviewDate DATETIME,
	Rating BIT,
	Review LONGTEXT,
	ApartmentId INT,
	PRIMARY KEY (Id)
) ENGINE=InnoDB;

CREATE TABLE ApartmentAmenities (
	Id INT NOT NULL,
	ApartmentId INT,
	AmenityId INT,
	Availability BIT,
	PRIMARY KEY (Id)
) ENGINE=InnoDB;

CREATE TABLE CommunityFeatures (
	Id INT NOT NULL,
	Name VARCHAR(1024) NOT NULL,
	Description LONGTEXT,
	PRIMARY KEY (Id)
) ENGINE=InnoDB;

CREATE TABLE CreditCards (
	Id INT NOT NULL,
	CardholderName VARCHAR(255) NOT NULL,
	CreditCardNumber CHAR(20),
	Balance DECIMAL(10 , 2),
	CardType VARCHAR(45),
	UserId INT,
	CVV CHAR(3),
	ExpirationDate VARCHAR(6),
	PRIMARY KEY (Id)
) ENGINE=InnoDB;

CREATE TABLE Users (
	Id INT NOT NULL,
	FirstName VARCHAR(45),
	LastName VARCHAR(45),
	Address VARCHAR(45),
	City VARCHAR(45),
	State VARCHAR(45),
	PostalCode VARCHAR(45),
	EmailAddress VARCHAR(45),
	PhoneNumber VARCHAR(15),
	Birthday VARCHAR(15),
	Type BIT,
	Status TINYINT,
	NumOfVisits INT,
	Username VARCHAR(255) NOT NULL,
	Password VARCHAR(255) NOT NULL,
	PRIMARY KEY (Id)
) ENGINE=InnoDB;

CREATE TABLE ApartmentCommunityFeatures (
	Id INT NOT NULL,
	ApartmentId INT,
	CommunityFeatureId INT,
	Availability BIT,
	PRIMARY KEY (Id)
) ENGINE=InnoDB;

CREATE UNIQUE INDEX Id_UNIQUE ON Users (Id ASC);

CREATE INDEX FK_Accounts_Users_idx ON CreditCards (UserId ASC);

CREATE INDEX FK_Applications_Users_idx ON Applications (AgentId ASC);

CREATE UNIQUE INDEX Id_UNIQUE ON ApartmentAmenities (Id ASC);

CREATE UNIQUE INDEX Id_UNIQUE ON Apartments (Id ASC);

CREATE UNIQUE INDEX Id_UNIQUE ON Applications (Id ASC);

CREATE INDEX FK_ApartmentCommunityFeatures_CommunityFeatures_idx ON ApartmentCommunityFeatures (CommunityFeatureId ASC);

CREATE UNIQUE INDEX Id_UNIQUE ON ApartmentCommunityFeatures (Id ASC);

CREATE INDEX FK_ApartmentAmenities_Apartments_idx ON ApartmentAmenities (ApartmentId ASC);

CREATE INDEX FK_Applications_Apartments_idx ON Applications (ApartmentId ASC);

CREATE INDEX FK_ApartmentCommunityFeatures_Apartments_idx ON ApartmentCommunityFeatures (ApartmentId ASC);

CREATE INDEX FK_Apartments_Users_idx ON Apartments (AgentId ASC);

CREATE UNIQUE INDEX Id_UNIQUE ON CreditCards (Id ASC);

CREATE UNIQUE INDEX Id_UNIQUE ON Amenities (Id ASC);

CREATE UNIQUE INDEX Id_UNIQUE ON CommunityFeatures (Id ASC);

CREATE UNIQUE INDEX Id_UNIQUE ON Reviews (Id ASC);

CREATE INDEX FK_ApartmentAmenities_Amenities_idx ON ApartmentAmenities (AmenityId ASC);

CREATE INDEX FK_Reviews_Apartments_idx ON Reviews (ApartmentId ASC);

