package com.example.a2019_05_30_listado.data.functions;

public enum Constant {

	NO_CONSTANT

	// Mathematics constants
	, M_GOLDEN_RATIO
	, M_E
	, M_E_M
	, M_LOG2E
	, M_LOG10E
	, M_LN2
	, M_LN10
	, M_4PI
	, M_4PI_3
	, M_2PI
	, M_2PI_360
	, M_360_2PI
	, M_2PIPI
	, M_PI
	, M_PI_2
	, M_PI_4
	, M_1_PI
	, M_2_PI
	, M_2_SQRTPI
	, M_SQRT2
	, M_SQRT1_2
	, M_SQRT2PI
	, M_SQRT3_4
	, M_SQRT3_2
	, M_1_SQRT2PI
	, M_1_SIN1

	// Physic Constants
	, F_EARTH_GRAVITY
	, F_GRAVITATIONAL
	, F_SPEED_OF_LIGHT_IN_VACUUM
	, F_PLANCK
	, F_PLANCK_EV
	, F_DIRAC
	, F_DIRAC_EV
	, F_ELEMENTARY_CHARGE
	, F_VACUUM_IMPEDANCE
	, F_VACUUM_PERMITIVITY
	, F_VACUUM_PERMEABILITY
	, F_ELECTRIC_CONSTANT
	, F_MAGNETIC_CONSTANT
	, F_AVOGADRO
	, F_BOLTZMANN
	, F_GAS
	, F_ELECTRON_MASS
	, F_PROTON_MASS
	, F_ATMOSPHERE
	;

	public static double get( Constant constant ){
		switch( constant ){
			// Mathematics constants
			case M_GOLDEN_RATIO:	return 1.6180339887498948482045868343656;
			case M_E:				return 2.7182818284590452354;
			case M_E_M:				return 0.5772156649015328606065;
			case M_LOG2E:			return 1.4426950408889634074;
			case M_LOG10E:			return 0.43429448190325182765;
			case M_LN2:				return 0.69314718055994530942;
			case M_LN10:			return 2.30258509299404568402;
			case M_4PI:				return 12.56637061435917295385;
			case M_4PI_3:			return 4.188790204786390984616;
			case M_2PI:				return 6.28318530717958647692;
			case M_2PI_360:			return 0.0174532925199432957692;
			case M_360_2PI:			return 57.295779513082320876798;
			case M_2PIPI:			return 19.73920880217871723766;
			case M_PI:				return 3.14159265358979323846;
			case M_PI_2:			return 1.57079632679489661923;
			case M_PI_4:			return 0.78539816339744830962;
			case M_1_PI:			return 0.31830988618379067154;
			case M_2_PI:			return 0.63661977236758134308;
			case M_2_SQRTPI:		return 1.12837916709551257390;
			case M_SQRT2:			return 1.41421356237309504880;
			case M_SQRT1_2:			return 0.70710678118654752440;
			case M_SQRT2PI:			return 2.50662827463100050241;
			case M_SQRT3_4:			return 0.433012701892219323381;
			case M_SQRT3_2:			return 0.866025403784438646763;
			case M_1_SQRT2PI:		return 0.39894228040143267794;
			case M_1_SIN1:			return 1.18839510577812121626;

			// Physic Constants
			case F_EARTH_GRAVITY:				return 9.80665;					// m / s^2
			case F_GRAVITATIONAL:				return 6.67408e-11;				// N * m^2 / kg^2
			case F_SPEED_OF_LIGHT_IN_VACUUM:	return 299792458;				// m / s
			case F_PLANCK:						return 6.62607015e-34;			// J * s
			case F_PLANCK_EV:					return 4.13566770e-15;			// eV * s
			case F_DIRAC:						return 1.05457182e-34;			// J * s		= reduced planck constant = h/(2*Pi)
			case F_DIRAC_EV:					return 6.58211957e-16;			// eV * s
			case F_ELEMENTARY_CHARGE:			return 1.602176634e-19;			// C
			case F_VACUUM_IMPEDANCE:			return 376.730313667;			// Ohms
			case F_VACUUM_PERMITIVITY:			return 8.8541878128e-12;		// C^2 / (N * m^2)
			case F_VACUUM_PERMEABILITY:			return 1.2566370614359172953850573533118e-6;		// T * m / A = N * A	= 4*Pi*(10^-7)
			case F_ELECTRIC_CONSTANT:			return 8.8541878128e-12;							// = F_VACUUM_PERMITIVITY;
			case F_MAGNETIC_CONSTANT:			return 1.2566370614359172953850573533118e-6;		// = F_VACUUM_PERMEABILITY;
			case F_AVOGADRO:					return 6.02214076e23;			// 1/mol			= NA
			case F_BOLTZMANN:					return 1.380649e-23;			// J / K			= k
			case F_GAS:							return 8.314462618;				// J / (mol * K)	= R = NA * k
			case F_ELECTRON_MASS:				return 9.1093837015e-31;		// Kg
			case F_PROTON_MASS:					return 1.67262192369e-27;		// Kg
			case F_ATMOSPHERE:					return 101325;					// Pa
		}
		return 0;	// NO_CONSTANT
	}

	public static String toString( Constant constant ){
		switch( constant ){
			// Mathematics constants
			case M_GOLDEN_RATIO:	return "GOLDEN";
			case M_E:				return "e";
			case M_E_M:				return "E_M";
			case M_LOG2E:			return "LOG2E";
			case M_LOG10E:			return "LOG10E";
			case M_LN2:				return "LN2";
			case M_LN10:			return "LN10";
			case M_4PI:				return "4PI";
			case M_4PI_3:			return "4PI_3";
			case M_2PI:				return "2PI";
			case M_2PI_360:			return "2PI_360";
			case M_360_2PI:			return "360_2PI";
			case M_2PIPI:			return "2PIPI";
			case M_PI:				return "PI";
			case M_PI_2:			return "PI_2";
			case M_PI_4:			return "PI_4";
			case M_1_PI:			return "1_PI";
			case M_2_PI:			return "2_PI";
			case M_2_SQRTPI:		return "2_SQRTPI";
			case M_SQRT2:			return "SQRT2";
			case M_SQRT1_2:			return "SQRT1_2";
			case M_SQRT2PI:			return "SQRT2PI";
			case M_SQRT3_4:			return "SQRT3_4";
			case M_SQRT3_2:			return "SQRT3_2";
			case M_1_SQRT2PI:		return "1_SQRT2PI";
			case M_1_SIN1:			return "1_SIN1";

			// Physic Constants
			case F_EARTH_GRAVITY:				return  "EARTH_GRAVITY";
			case F_GRAVITATIONAL:				return  "GRAVITATIONAL";
			case F_SPEED_OF_LIGHT_IN_VACUUM:	return  "SPEED_OF_LIGHT_IN_VACUUM";
			case F_PLANCK:						return  "PLANCK";
			case F_PLANCK_EV:					return  "PLANCK_EV";
			case F_DIRAC:						return  "DIRAC";
			case F_DIRAC_EV:					return  "DIRAC_EV";
			case F_ELEMENTARY_CHARGE:			return  "ELEMENTARY_CHARGE";
			case F_VACUUM_IMPEDANCE:			return  "VACUUM_IMPEDANCE";
			case F_VACUUM_PERMITIVITY:			return  "VACUUM_PERMITIVITY";
			case F_VACUUM_PERMEABILITY:			return  "VACUUM_PERMEABILITY";
			case F_ELECTRIC_CONSTANT:			return  "ELECTRIC_CONSTANT";
			case F_MAGNETIC_CONSTANT:			return  "MAGNETIC_CONSTANT";
			case F_AVOGADRO:					return  "AVOGADRO";
			case F_BOLTZMANN:					return  "BOLTZMANN";
			case F_GAS:							return  "GAS";
			case F_ELECTRON_MASS:				return  "ELECTRON_MASS";
			case F_PROTON_MASS:					return  "PROTON_MASS";
			case F_ATMOSPHERE:					return  "ATMOSPHERE";
		}
		return "";	// NO_CONSTANT
	}
}
